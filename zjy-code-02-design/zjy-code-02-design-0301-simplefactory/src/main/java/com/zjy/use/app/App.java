package com.zjy.use.app;


import com.zjy.use.factory.ChartFactory;
import com.zjy.use.model.Chart;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/28
 * Time: 16:52
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class App {
    public static void main(String[] args) {

        final Chart line = ChartFactory.getInstance("line");
        line.display();
    }
}
