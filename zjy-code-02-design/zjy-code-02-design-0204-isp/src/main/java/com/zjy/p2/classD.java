package com.zjy.p2;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/28
 * Time: 9:45
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class classD implements Interface1,Interface3 {
    public void method1() {
        System.out.println("类D实现了接口1的method1方法");
    }

    public void method4() {
        System.out.println("类D实现了接口3的method4方法");
    }

    public void method5() {
        System.out.println("类D实现了接口3的method5方法");
    }
}
