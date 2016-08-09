package com.zjy.app;

import com.zjy.dao.UserDao;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjylllf
 * Date: 2016/2/3
 * Time: 11:05
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class MainApp {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        //第一次查询
        userDao.getUserByName("zhangjiyong");
        //第二次查询
        userDao.getUserByName("zhangjiyong");

        userDao.reload();

        System.out.println("after reload...........");

        //第一次查询
        userDao.getUserByName("zhangjiyong");
        //第二次查询
        userDao.getUserByName("zhangjiyong");

    }
}
