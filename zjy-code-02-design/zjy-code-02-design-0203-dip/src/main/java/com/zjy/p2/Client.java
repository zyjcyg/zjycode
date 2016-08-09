package com.zjy.p2;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/27
 * Time: 16:57
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class Client {
    public static void main(String[] args) {
        Book book = new Book();
        Mother mother = new Mother();
        mother.narrate(book);

        Newspaper news = new Newspaper();

        mother.narrate(news);

    }
}


