package com.zjy.p1;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/27
 * Time: 17:49
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class classB implements Interface1 {

    public void method1() {
        System.out.println("类B实现接口Interface的方法1");
    }

    public void method2() {
        System.out.println("类B实现接口Interface的方法2");
    }

    public void method3() {
        System.out.println("类B实现接口Interface的方法3");
    }

    //对于类B来说，method4和method5不是必需的，但是由于接口A中有这两个方法，
    //所以在实现过程中即使这两个方法的方法体为空，也要将这两个没有作用的方法进行实现。
    public void method4() {
    }

    public void method5() {
    }
}
