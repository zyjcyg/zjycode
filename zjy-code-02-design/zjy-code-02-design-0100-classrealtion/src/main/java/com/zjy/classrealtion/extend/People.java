package com.zjy.classrealtion.extend;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/27
 * Time: 14:46
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class People implements IPeople {
    public void eat() {
        System.out.println("我会吃");
    }

    public void sleep() {

        System.out.println("我会睡");
    }

    public void study() {
        System.out.println("我还会学习");
    }
}
