package com.zjy.classrealtion.composition;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/27
 * Time: 14:35
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class App {

    public static void main(String[] args) {

        //组合是一种耦合度更强的关联关系。存在组合关系的类表示“整体-部分”的关联关系，
        // “整体”负责“部分”的生命周期，他们之间是共生共死的；并且“部分”单独存在时没有任何意义。
        //People与Soul、Body之间是组合关系，当人的生命周期开始时，必须同时有灵魂和肉体；
        //当人的生命周期结束时，灵魂肉体随之消亡；无论是灵魂还是肉体，都不能单独存在，他们必须作为人的组成部分存在

        Soul soul = new Soul();
        soul.setName("灵魂");
        Body body = new Body();
        body.setName("身体");


        Peolple peolple = new Peolple(soul, body);
        peolple.eat();
        peolple.study();

    }
}
