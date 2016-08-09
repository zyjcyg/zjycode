package com.zjy.useexample.app;

import com.zjy.useexample.factory.ShapeFactory;
import com.zjy.useexample.model.Shape;
import com.zjy.useexample.utils.UnSupportedShapeException;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjylllf
 * Date: 2016/2/3
 * Time: 15:48
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class App {
    public static void main(String[] args) {
        try {
            final Shape tt = ShapeFactory.getInstance("ts");
            tt.draw();
            tt.erase();
        } catch (UnSupportedShapeException e) {
            System.out.println(e.getMessage());
        }

    }
}
