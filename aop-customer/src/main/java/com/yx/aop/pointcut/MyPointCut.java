package com.yx.aop.pointcut;

/**
 * 切点： classPath +  mehtod
 * @author yx start
 * @create 2019/12/12,21:07
 */
public class MyPointCut {


    public MyPointCut(String classPatten, String methodPatten) {
        this.classPatten = classPatten;
        this.methodPatten = methodPatten;
    }

    // 类的表达式
    private String  classPatten ;

    // method 方法的正则表达式
    private String methodPatten ;

    public String getClassPatten() {
        return classPatten;
    }

    public void setClassPatten(String classPatten) {
        this.classPatten = classPatten;
    }

    public String getMethodPatten() {
        return methodPatten;
    }

    public void setMethodPatten(String methodPatten) {
        this.methodPatten = methodPatten;
    }
}
