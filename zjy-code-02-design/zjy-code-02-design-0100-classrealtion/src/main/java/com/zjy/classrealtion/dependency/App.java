package com.zjy.classrealtion.dependency;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/27
 * Time: 13:37
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class App {

    public static void main(String[] args) {
        People people = new People();
        Book book = new Book();
        book.setName("研磨设计模式");
        people.read(book);
    }

}
