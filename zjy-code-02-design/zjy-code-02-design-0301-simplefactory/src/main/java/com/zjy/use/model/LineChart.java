package com.zjy.use.model;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/28
 * Time: 16:47
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class LineChart implements Chart {

    public LineChart() {
        System.out.println("创建折线图");
    }

    public void display() {
        System.out.println("显示折线图");
    }
}
