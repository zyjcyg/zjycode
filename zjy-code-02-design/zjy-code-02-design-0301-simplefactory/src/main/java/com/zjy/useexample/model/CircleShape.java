package com.zjy.useexample.model;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjylllf
 * Date: 2016/2/3
 * Time: 15:37
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class CircleShape implements Shape {
    public void draw() {
        System.out.println("画了一个圆形。。。。。。。。。。。");
    }

    public void erase() {

        System.out.println("擦除一个圆形。。。。。。。。。。。");
    }
}
