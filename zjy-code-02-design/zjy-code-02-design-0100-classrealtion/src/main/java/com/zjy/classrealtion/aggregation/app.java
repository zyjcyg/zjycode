package com.zjy.classrealtion.aggregation;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/27
 * Time: 13:50
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class app {


    // 聚合关系是关联关系的一种，耦合度强于关联，他们的代码表现是相同的，仅仅是在语义上有所区别：
    // 关联关系的对象间是相互独立的，而聚合关系的对象之间存在着包容关系，他们之间是“整体-个体”的相互关系。
    public static void main(String[] args) {

        final Car car = new Car();
        car.setCarType("皮卡");
        final House house = new House();
        house.setAddress("河南息县曹寨村");
        People people = new People();
        people.setCar(car);
        people.setHouse(house);

        people.driver();
        people.sleep();
    }
}
