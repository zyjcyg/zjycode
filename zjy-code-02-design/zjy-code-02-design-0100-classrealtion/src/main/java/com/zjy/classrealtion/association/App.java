package com.zjy.classrealtion.association;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/27
 * Time: 13:45
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class App {


    //相对独立的对象，当一个对象的实例与另一个对象的一些特定实例存在固定的对应关系时，这两个对象之间为关联关系。关联关系分为单向关联和双向关联。
    //在java中，单向关联表现为：类A当中使用了类B，其中类B是作为类A的成员变量。双向关联表现为：类A当中使用了类B作为成员变量；同时类B中也使用了类A作为成员变量
    public static void main(String[] args) {
        Father father = new Father();
        father.setName("父亲");
        Son son = new Son();
        son.setName("儿子");
        father.setSon(son);
        son.setFather(father);

        son.getGift();
        father.getGift();
    }
}
