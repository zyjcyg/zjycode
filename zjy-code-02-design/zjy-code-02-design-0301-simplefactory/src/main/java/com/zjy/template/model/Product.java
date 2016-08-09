package com.zjy.template.model;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/28
 * Time: 16:30
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public abstract class Product {

    //所有产品类的公共业务方法
    public void methodSame() {
        System.out.println("所有产品类的公共业务方法");
    }

    //声明抽象业务方法
    public abstract void methodDiff();
}
