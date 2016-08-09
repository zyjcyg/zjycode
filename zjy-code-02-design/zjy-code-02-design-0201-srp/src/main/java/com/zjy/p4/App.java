package com.zjy.p4;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/27
 * Time: 15:47
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class App {

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.breatheAir("牛");
        animal.breatheAir("羊");
        animal.breatheAir("猪");
        animal.breatheWater("鱼");

    }
}
