package com.yx.aop.invocationHandler;

import com.yx.aop.aspect.MyAspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yx start
 * @create 2019/12/12,22:13
 */
public class MyInvoCationHandler implements InvocationHandler {

private MyAspect myAspect;

private Object target;

    public MyInvoCationHandler(MyAspect myAspect, Object target) {
        super();
        this.myAspect = myAspect;
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println( " 如果符合方法，执行增强逻辑 ");
        // 如果符合方法，执行增强逻辑
        if(method.getName().matches(this.myAspect.getMyPointCut().getMethodPatten())){
            return  this.myAspect.getMyAdvise().invoke(this.target,method,args);
        }
        // 不需要增强，直接调用业务方法的
        return method.invoke(target,args);
    }



}
