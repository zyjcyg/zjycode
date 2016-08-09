package com.zjy.p1;

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
public class CampanyManager {

    public List<Employee> getAllEmployee() {
        final ArrayList<Employee> subEmployees = new ArrayList<Employee>();
        for (int i = 0; i < 100; i++) {
            Employee employee = new Employee();
            employee.setId("总公司" + i);
            subEmployees.add(employee);

        }
        return subEmployees;
    }

    public  void printAllEmployee(SubCampanyManager subCampanyManager) {
        final List<SubEmployee> allSubEmployee = subCampanyManager.getAllEmployee();
        for (SubEmployee subEmployee : allSubEmployee) {
            System.out.println(subEmployee.getId());

        }

        final List<Employee> allEmployee = this.getAllEmployee();
        for (Employee employee : allEmployee) {
            System.out.println(employee.getId());
        }
    }

}
