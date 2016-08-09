package com.zjy.template.app;

import com.zjy.template.factory.Factory;
import com.zjy.template.model.Product;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/28
 * Time: 16:39
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class App {

    public static void main(String[] args) {
        final Product a = Factory.getInstance("a");
        a.methodSame();
        a.methodDiff();
    }
}
