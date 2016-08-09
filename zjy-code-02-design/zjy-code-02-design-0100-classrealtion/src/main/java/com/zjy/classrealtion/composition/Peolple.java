package com.zjy.classrealtion.composition;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/27
 * Time: 14:30
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class Peolple {

    private Soul soul;

    private Body body;

    //组合关系中的成员变量一般会在构造方法中赋值


    public Peolple() {
    }

    public Peolple(Soul soul, Body body) {
        this.soul = soul;
        this.body = body;
    }

    public Soul getSoul() {
        return soul;
    }

    public void setSoul(Soul soul) {
        this.soul = soul;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public void eat() {
        System.out.println("吃饭用" + body.getName());
    }

    public void study() {
        System.out.println("学习用" + soul.getName());

    }


}
