package entity;

import org.bson.Document;

import java.sql.Timestamp;
import java.util.List;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/15
 * Time: 16:47
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zjyll
 */
public class User extends Document{

    private String id;
    private int age;
    private String pwd;
    private Name name;
    private Timestamp birth;

    private List<String> special;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Timestamp getBirth() {
        return birth;
    }

    public void setBirth(Timestamp birth) {
        this.birth = birth;
    }

    public List<String> getSpecial() {
        return special;
    }

    public void setSpecial(List<String> special) {
        this.special = special;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", age=" + age +
                ", pwd='" + pwd + '\'' +
                ", name=" + name +
                ", birth=" + birth +
                ", special=" + special +
                '}';
    }
}
