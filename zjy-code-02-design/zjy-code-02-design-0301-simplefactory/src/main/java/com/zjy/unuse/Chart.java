package com.zjy.unuse;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/28
 * Time: 16:17
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class Chart {

    private String type;

    public Chart(Object[][] data, String type) {
        this.type = type;
        if (type.equals("histogram")) {
            System.out.println("初始化柱状图形");

        } else if (type.equals("pie")) {
            System.out.println("初始化饼状图形");
        } else if (type.equals("line")) {
            System.out.println("初始化折线状图形");
        }
    }

    public void display() {
        if (this.type.equals("histogram")) {
            System.out.println("显示柱状图形");

        } else if (this.type.equals("pie")) {
            System.out.println("显示饼状图形");
        } else if (this.type.equals("line")) {
            System.out.println("显示折线状图形");
        }
    }
}
