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
public class PieChart implements Chart {

    public PieChart() {
        System.out.println("创建饼状图");
    }

    public void display() {
        System.out.println("显示饼状图");
    }
}
