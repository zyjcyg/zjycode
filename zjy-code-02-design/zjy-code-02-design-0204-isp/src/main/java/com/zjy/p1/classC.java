package com.zjy.p1;

/**
 * <pre>
 * Created with Interface1ntelliJ Interface1DEA.
 * User: zjyll
 * Date: 2016/1/27
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class classC {
    public void depend1(Interface1 i){
        i.method1();
    }
    public void depend2(Interface1 i){
        i.method4();
    }
    public void depend3(Interface1 i){
        i.method5();
    }
}

