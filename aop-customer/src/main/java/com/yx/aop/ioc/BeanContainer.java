package com.yx.aop.ioc;

import com.yx.aop.aspect.MyAspect;
import com.yx.aop.invocationHandler.MyInvoCationHandler;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yx start
 * @create 2019/12/12,21:19
 */
public class BeanContainer {
    private MyAspect myAspect;

     private Map<String,Class<?>> beadDefinition  =new HashMap<>();


    public BeanContainer(MyAspect myAspect) {
        this.myAspect = myAspect;
    }

    public void addBeanDefinition(String beanName, Class<?> beanClass){
        beadDefinition.put(beanName,beanClass);
    }

    /** 模拟spring获取对象
     * 获取bean name 返回给用户对象
     * @param beanName
     * @return
     */
    public Object getBean(String beanName) throws IllegalAccessException, InstantiationException {
        // 创建对象实例
        Object object = createInstance(beanName);
        // 增强 逻辑
        object = proxyEnHance(object);

        return object ;
    }

    /**
     * 增强逻辑采用动态代理
     * @param object
     * @return
     */
    private Object proxyEnHance(Object object) {
        // 需要增强的类
        Class<?> beanClass = object.getClass();
        if(beanClass.getName().matches(this.myAspect.getMyPointCut().getClassPatten())){ //符合这个classPatten 就进行增强
             return  Proxy.newProxyInstance(beanClass.getClassLoader(),
                     beanClass.getInterfaces(), new MyInvoCationHandler(this.myAspect,object));
        }
        return object ;

    }

    private Object createInstance(String beanName) throws IllegalAccessException, InstantiationException {
        Class<?> aClass = beadDefinition.get(beanName);
        Object o = aClass.newInstance();
        return o ;
    }

// 代理增强：原理： 在外面包一层（前置和后置，环绕）
    //   1.必须要被代理对象实现相同的接口 。或者相同的父类 ;2. 被代理对象和相同的接口
    // 动态代理


}
