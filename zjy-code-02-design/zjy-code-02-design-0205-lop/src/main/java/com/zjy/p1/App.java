package com.zjy.p1;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/28
 * Time: 14:32
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class App {

    public static void main(String[] args) {

        CampanyManager campanyManager = new CampanyManager();

        campanyManager.printAllEmployee(new SubCampanyManager());
    }
}
