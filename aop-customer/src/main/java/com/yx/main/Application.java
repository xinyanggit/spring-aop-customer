package com.yx.main;

import com.yx.service.PersonService;
import com.yx.service.TomPersonService;

/**
 * @author yx start
 * @create 2019/12/11,23:17
 */
public class Application {

    public static void main(String[] args) {
//        计算程序运行的时间进行统计,统计记录。每个方法都是需要自己添加，太麻烦了
        // 原生方法太麻烦了  ==start
        PersonService personService = new TomPersonService();
        personService.doSomeThingForJob("happy");
        // 原生方法太麻烦了  == end

    }
}
