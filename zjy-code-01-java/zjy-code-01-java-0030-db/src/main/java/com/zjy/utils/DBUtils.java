package com.zjy.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjylllf
 * Date: 2016/7/22
 * Time: 13:56
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class DBUtils {
    public static Connection getConnection() {
        String jdbcURL = "jdbc:mysql://localhost:3306/test";
        String jdbcDriver = "com.mysql.jdbc.Driver";
        String jdbcUser = "root";
        String jdbcPwd = "123456";
        Connection connection = null;
        DbUtils.loadDriver(jdbcDriver);
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        final Connection connection = getConnection();

        QueryRunner queryRunner = new QueryRunner();
        try {

            final List<Map<String, Object>> query = queryRunner.query(connection, "select * from test2", new MapListHandler());

            for (Map<String, Object> stringObjectMap : query) {
                JSONObject jsonObject = new JSONObject();
                System.out.println(stringObjectMap.toString());
                jsonObject.putAll(stringObjectMap);

                System.out.println(jsonObject.toJSONString());
                System.out.println(jsonObject.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
