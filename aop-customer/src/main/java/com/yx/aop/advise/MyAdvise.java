package com.yx.aop.advise;

import java.lang.reflect.Method;

/**
 * @author yx start
 * @create 2019/12/11,23:43
 */
public interface MyAdvise {

     /***
      * 自定义加强方法  target 目标对象，  methodName 执行的方法  args执行的参数
      * @param target
      * @param methodName
      * @param args
      * @return
      */
     public Object invoke(Object target, Method methodName,Object[] args);
}
