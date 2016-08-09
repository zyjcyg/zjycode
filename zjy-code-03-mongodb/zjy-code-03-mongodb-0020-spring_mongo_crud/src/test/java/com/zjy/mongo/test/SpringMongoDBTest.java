package com.zjy.mongo.test;

import com.zjy.mongo.dao.UserDao;
import com.zjy.mongo.dao.impl.UserDaoImpl;
import com.zjy.mongo.entity.NameEntity;
import com.zjy.mongo.entity.UserEntity;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/18
 * Time: 14:21
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zjyll
 */
public class SpringMongoDBTest {

    public static void main(String[] args) {

        System.out.println("Bootstrapping HelloMongo");

        ConfigurableApplicationContext context = null;
        context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = context.getBean(UserDaoImpl.class);
        userDao._test();
        UserEntity entity1 = new UserEntity();
        entity1.setId("1");

        entity1.setAge(1);
        entity1.setBirth(new Date());
        entity1.setPassword("asdfasdf");
        entity1.setRegionName("北京");
        entity1.setWorks(1);
        NameEntity nameEntity = new NameEntity();
        nameEntity.setUsername("zhangjiyong");
        nameEntity.setNickname("yong");

        entity1.setName(nameEntity);
//        userDao.insert(entity1);
        userDao.update(entity1);
//        userDao.createCollection();
//
        List<UserEntity> list = userDao.findList(0, 2);
        System.out.println(list.size());
        for (UserEntity userEntity : list) {
            System.out.println(userEntity.toString());
        }
//        for (UserEntity e : list) {
//            System.out.println("all - id=" + e.getId() + ", age=" + e.getAge() + ", password=" + e.getPassword() + ", regionName=" + e.getRegionName() + ", special=" + Arrays.toString(e.getSpecial())
//                    + ", name=" + e.getName().getUsername() + "-" + e.getName().getNickname() + ", birth=" + e.getBirth());
//        }
//
//        list = userDao.findListByAge(1);
//        for (UserEntity e : list) {
//            System.out.println("age=1 - id=" + e.getId() + ", age=" + e.getAge() + ", password=" + e.getPassword() + ", regionName=" + e.getRegionName() + ", special="
//                    + Arrays.toString(e.getSpecial()) + ", name=" + e.getName().getUsername() + "-" + e.getName().getNickname() + ", birth=" + e.getBirth());
//        }
//
//        UserEntity e = userDao.findOne("1");
//        System.out.println("id=1 - id=" + e.getId() + ", age=" + e.getAge() + ", password=" + e.getPassword() + ", regionName=" + e.getRegionName() + ", special=" + Arrays.toString(e.getSpecial())
//                + ", name=" + e.getName().getUsername() + "-" + e.getName().getNickname() + ", birth=" + e.getBirth());
//
//        e = userDao.findOneByUsername("limingnihao");
//        System.out.println("username=limingnihao - id=" + e.getId() + ", age=" + e.getAge() + ", password=" + e.getPassword() + ", regionName=" + e.getRegionName() + ", special="
//                + Arrays.toString(e.getSpecial()) + ", name=" + e.getName().getUsername() + "-" + e.getName().getNickname() + ", birth=" + e.getBirth());
//
//
//        System.out.println("DONE!");
    }

}
