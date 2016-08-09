package com.zjy.p2;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/27
 * Time: 16:17
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class Son  extends Sub{

    public int add(int a, int b) {
        return a + b;
    }

    public int add100(int a, int b) {
        return minus(a, b) + 100;
    }

}
