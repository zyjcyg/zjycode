package com.zjy.useexample.utils;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjylllf
 * Date: 2016/2/3
 * Time: 15:47
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class UnSupportedShapeException extends Exception {
    @Override
    public String getMessage() {
        return "不支持图形";
    }
}
