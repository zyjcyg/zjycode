package com.zjy.p2;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/28
 * Time: 14:18
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class SubCampanyManager {

    public List<SubEmployee> getAllEmployee() {
        final ArrayList<SubEmployee> subEmployees = new ArrayList<SubEmployee>();
        for (int i = 0; i < 100; i++) {
            SubEmployee subEmployee = new SubEmployee();
            subEmployee.setId("分公司" + i);
            subEmployees.add(subEmployee);

        }
        return subEmployees;
    }

    public  void printAllEmployee() {
        final List<SubEmployee> allSubEmployee = getAllEmployee();
        for (SubEmployee subEmployee : allSubEmployee) {
            System.out.println(subEmployee.getId());

        }

    }
}
