package com.zjy.unuse;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/28
 * Time: 16:23
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class App {
    public static void main(String[] args) {
        Chart chart = new Chart(new Object[][]{}, "pie");
        chart.display();
    }
}
