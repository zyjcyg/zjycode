package com.zjy.classrealtion.dependency;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/27
 * Time: 13:34
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class People {



    //对于两个相对独立的对象，当一个对象负责构造另一个对象的实例，或者依赖另一个对象的服务时，这两个对象之间主要体现为依赖关系

    //类A当中使用了类B，其中类B是作为类A的方法参数、方法中的局部变量、或者静态方法调用。
    public void read(Book book) {
        System.out.println(book.getName());
    }
}
