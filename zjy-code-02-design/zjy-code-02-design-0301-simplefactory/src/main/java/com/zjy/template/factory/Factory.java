package com.zjy.template.factory;

import com.zjy.template.model.ConcreteProductA;
import com.zjy.template.model.ConcreteProductB;
import com.zjy.template.model.Product;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/28
 * Time: 16:34
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class Factory {
    //静态工厂方法,获取具体实例对象
    public static Product getInstance(String type) {
        Product product = null;
        if (type.equalsIgnoreCase("a")) {
            product = new ConcreteProductA();
            System.out.println("初始化设置productA");
        } else if (type.equalsIgnoreCase("b")) {
            product = new ConcreteProductB();
            System.out.println("初始化设置productB");
        }
        return product;
    }
}
