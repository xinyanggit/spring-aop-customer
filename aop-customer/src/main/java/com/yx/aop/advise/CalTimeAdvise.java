package com.yx.aop.advise;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 计算时间增强
 * @author yx start
 * @create 2019/12/12,0:15
 */
public class CalTimeAdvise implements  MyAdvise {
    @Override
    public Object invoke(Object target, Method methodName, Object[] args) {
        long startTime = System.currentTimeMillis();
        Object invoke = null;
        try {
            //执行加强的方法
             invoke = methodName.invoke(target, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println( "花费时间==>" + (endTime-startTime)/1000 +"s" );
        return invoke ;
    }
}
