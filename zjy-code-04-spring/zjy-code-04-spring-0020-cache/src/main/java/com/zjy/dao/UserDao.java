package com.zjy.dao;

import com.zjy.model.User;
import com.zjy.utils.MyCacheManager;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjylllf
 * Date: 2016/2/3
 * Time: 10:27
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class UserDao {

    private MyCacheManager<User> cacheManager;

    public UserDao() {
        cacheManager = new MyCacheManager<User>();
    }

    public User getUserByName(String userName) {
        //首先查询缓存
        User user = cacheManager.getValue(userName);
        if (user != null) {
            System.out.println("get from cache........." + userName);
            return user;
        }

        user = getFromDB(userName);
        if (user != null) {
            System.out.println("update cache................");

            cacheManager.addOrUpdateCache(userName, user);
        }

        return user;
    }


    public void reload() {
        System.out.println("clear all cache...............");
        cacheManager.evictCache();
    }

    public void reloadByKey(String key) {
        System.out.println("clear cache by key...............");
        cacheManager.evictCache(key);
    }

    private User getFromDB(String userName) {
        System.out.println("real querying db..........." + userName);

        return new User(userName);
    }
}
