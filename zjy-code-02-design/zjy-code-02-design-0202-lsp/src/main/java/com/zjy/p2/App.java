package com.zjy.p2;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/27
 * Time: 16:08
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class App {

    public static void main(String[] args) {
        Sub sub = new Sub();
        System.out.println(sub.minus(10, 5));

        Son son = new Son();
        System.out.println(son.minus(10, 5));
        System.out.println(son.add100(10, 10));
    }
}
