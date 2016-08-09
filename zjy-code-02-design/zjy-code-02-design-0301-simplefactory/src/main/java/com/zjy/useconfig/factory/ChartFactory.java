package com.zjy.useconfig.factory;

import com.zjy.useconfig.model.HistogramChart;
import com.zjy.useconfig.model.PieChart;
import com.zjy.useconfig.model.Chart;
import com.zjy.useconfig.model.LineChart;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/28
 * Time: 17:07
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class ChartFactory {
    public static Chart getInstance(String type) {
        Chart chart = null;
        if (type.equalsIgnoreCase("H")) {
            chart = new HistogramChart();
            System.out.println("初始化柱状图");

        } else if (type.equalsIgnoreCase("P")) {
            chart = new PieChart();
            System.out.println("初始化饼状图");

        } else if (type.equalsIgnoreCase("L")) {
            chart = new LineChart();
            System.out.println("初始化折线图");
        }

        return chart;
    }
}
