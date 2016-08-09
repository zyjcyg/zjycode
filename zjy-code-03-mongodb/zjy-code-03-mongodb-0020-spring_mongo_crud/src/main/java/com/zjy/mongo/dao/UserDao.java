package com.zjy.mongo.dao;

import com.zjy.mongo.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/18
 * Time: 13:49
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zjyll
 */


@Transactional
public interface UserDao {

    public abstract void _test();

    public abstract void createCollection();

    public abstract List<UserEntity> findList(int skip, int limit);

    public abstract List<UserEntity> findListByAge(int age);

    public abstract UserEntity findOne(String id);

    public abstract UserEntity findOneByUsername(String username);

    public abstract void insert(UserEntity entity);

    public abstract void update(UserEntity entity);

}