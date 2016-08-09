package com.zjy.classrealtion.extend;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/27
 * Time: 14:48
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class App {

    public static void main(String[] args) {

        //继承表示类与类（或者接口与接口）之间的父子关系。在java中，
        // 用关键字extends表示继承关系。UML图例中，继承关系用实线+空心箭头表示，箭头指向父类。
        People people = new People();
        people.eat();
        people.sleep();
        people.study();

    }
}
