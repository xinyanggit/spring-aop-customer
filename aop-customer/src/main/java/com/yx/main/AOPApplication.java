package com.yx.main;

import com.yx.aop.advise.CalTimeAdvise;
import com.yx.aop.advise.MyAdvise;
import com.yx.aop.aspect.MyAspect;
import com.yx.aop.ioc.BeanContainer;
import com.yx.aop.pointcut.MyPointCut;
import com.yx.service.JoBPersonService;
import com.yx.service.PersonService;
import com.yx.service.TomPersonService;

/**
 * @author yx start
 * @create 2019/12/12,21:09
 */
public class AOPApplication {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        // 切点和切面都直接定义了
        MyAdvise myAdvise = new CalTimeAdvise();
        String classPatten = "com.yx.service.*" ;
        String methodPatten = "doSomeThingForJob" ;
        MyPointCut myPointCut = new MyPointCut(classPatten,methodPatten) ;
        MyAspect myAspect = new MyAspect(myAdvise,myPointCut);

        // 用户直接使用 new 对象。这个做不了增强的 ，所以工程 需要 ioC 融合，
        // 我们这里简单的实现一个IOc容器
//        TomPersonService personService = new TomPersonService() ;
//        personService.doSomeThingByPath("method- one ");
//        personService.doSomeThingForJob("methods-two");

        BeanContainer beanContainer = new BeanContainer(myAspect);
        beanContainer.addBeanDefinition("tomPersonService", TomPersonService.class);
        beanContainer.addBeanDefinition("jobPersonService", JoBPersonService.class);
        //直接使用哈
        PersonService tomPersonService= (PersonService)beanContainer.getBean("tomPersonService");
        tomPersonService.doSomeThingForJob("aop test==>Tom");
        PersonService joBPersonService= (PersonService)beanContainer.getBean("jobPersonService");
        joBPersonService.doSomeThingForJob("aop=>job==>");

    }
}
