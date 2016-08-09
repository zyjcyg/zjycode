package com.zjy.p2;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/28
 * Time: 9:38
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class classA {
    public void depend1(Interface1 i){
        i.method1();
    }
    public void depend2(Interface2 i){
        i.method2();
    }
    public void depend3(Interface2 i){
        i.method3();
    }
}
