package com.zjy.p3;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/27
 * Time: 15:46
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class Animal {

    public Animals breathe(String animal) {
        if (animal.equalsIgnoreCase("鱼")) {

            System.out.println(animal + "呼吸水");

            return new Fish();
        } else {

            System.out.println(animal + "呼吸空气");

            return new Birds();
        }
    }
}
