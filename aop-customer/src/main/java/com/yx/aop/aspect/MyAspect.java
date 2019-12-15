package com.yx.aop.aspect;

import com.yx.aop.advise.MyAdvise;
import com.yx.aop.pointcut.MyPointCut;

/**
 * 将切点和切面合并
 * @author yx start
 * @create 2019/12/12,21:12
 */
public class MyAspect {

    /**
     * 增强逻辑实现
     */
    private MyAdvise myAdvise ;

    /**
     * 需要增强的切点
     */
    private MyPointCut myPointCut  ;

    public MyAspect(MyAdvise myAdvise, MyPointCut myPointCut) {
        this.myAdvise = myAdvise;
        this.myPointCut = myPointCut;
    }

    public MyAdvise getMyAdvise() {
        return myAdvise;
    }

    public void setMyAdvise(MyAdvise myAdvise) {
        this.myAdvise = myAdvise;
    }

    public MyPointCut getMyPointCut() {
        return myPointCut;
    }

    public void setMyPointCut(MyPointCut myPointCut) {
        this.myPointCut = myPointCut;
    }
}
