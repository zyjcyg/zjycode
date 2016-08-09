package com.zjy.useexample.factory;

import com.zjy.useexample.model.CircleShape;
import com.zjy.useexample.model.Shape;
import com.zjy.useexample.model.SquareShape;
import com.zjy.useexample.model.TriangleShape;
import com.zjy.useexample.utils.UnSupportedShapeException;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjylllf
 * Date: 2016/2/3
 * Time: 15:40
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class ShapeFactory {


    public static Shape getInstance(String shapeType) throws UnSupportedShapeException {
        Shape shape = null;
        if (shapeType.equalsIgnoreCase("cs")) {
            shape = new CircleShape();
        } else if (shapeType.equalsIgnoreCase("ts")) {
            shape = new TriangleShape();
        } else if (shapeType.equalsIgnoreCase("ss")) {
            shape = new SquareShape();
        } else {

            throw new UnSupportedShapeException();
        }
        return shape;
    }
}
