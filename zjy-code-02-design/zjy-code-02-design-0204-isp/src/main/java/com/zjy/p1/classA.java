package com.zjy.p1;

/**
 * <pre>
 * Created with Interface1ntelliJ Interface1DEA.
 * User: zjyll
 * Date: 2016/1/27
 * Time: 17:48
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class classA {
    public void depend1(Interface1 i){
        i.method1();
    }
    public void depend2(Interface1 i){
        i.method2();
    }
    public void depend3(Interface1 i){
        i.method3();
    }
}
