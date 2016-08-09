package com.zjy.useconfig.app;

import com.zjy.useconfig.factory.ChartFactory;
import com.zjy.useconfig.utls.XMLUtils;
import com.zjy.useconfig.model.Chart;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/28
 * Time: 17:11
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class App {

    public static void main(String[] args) {
        final Chart chart = ChartFactory.getInstance(XMLUtils.getChartType());
        chart.display();
    }
}
