package com.zjy.p1;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/27
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class classD implements Interface1 {

    public void method1() {
        System.out.println("类D实现接口Interface的方法1");
    }

    //对于类D来说，method2和method3不是必需的，但是由于接口A中有这两个方法，
    //所以在实现过程中即使这两个方法的方法体为空，也要将这两个没有作用的方法进行实现。
    public void method2() {
    }

    public void method3() {
    }

    public void method4() {
        System.out.println("类D实现接口Interface的方法4");
    }

    public void method5() {
        System.out.println("类D实现接口Interface的方法5");
    }
}
