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
public class People {


    //聚合关系中作为成员变量的类一般使用set方法赋值
    private Car car;
    private House house;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public void driver() {
        System.out.println("车的型号是:" + car.getCarType());
    }

    public void sleep() {
        System.out.println("我在房子里睡觉:" + house.getAddress());
    }
}
