package com.zjy.p2;


/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/27
 * Time: 17:41
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */

public class App {
    public static void main(String[] args){
        classA a = new classA();
        a.depend1(new classB());
        a.depend2(new classB());
        a.depend3(new classB());

        classC c = new classC();
        c.depend1(new classD());
        c.depend2(new classD());
        c.depend3(new classD());
    }
}
