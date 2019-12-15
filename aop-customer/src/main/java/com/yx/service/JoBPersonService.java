package com.yx.service;

/**
 * @author yx start
 * @create 2019/12/11,23:15
 */
public class JoBPersonService implements  PersonService{

    @Override
    public void doSomeThingForJob(String args) {
        // 计算统计时间==>采用自定义AOP
//        long startTime = System.currentTimeMillis();
         System.out.println("yx is doSomeThing=>"+args );

            for (int i = 0; i < 1000000; i++) {
              //  System.out.println(this.getClass().getName() + "==>laowang==>" + i + "==>" + args);
            }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        long endTime = System.currentTimeMillis();
//        System.out.println( "花费时间==>" + (endTime-startTime)/1000 +"s" );
    }


}
