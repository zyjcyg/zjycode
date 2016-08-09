package com.zjy.mongo.entity;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/18
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zjyll
 */
public class NameEntity {

    private String username;
    private String nickname;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "NameEntity{" +
                "username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
