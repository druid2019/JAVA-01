package com.jinjie.origin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/2/20 19:30
 * @Description ${description}
 */
public class JdbcUtills {
    public static void main(String[] args) throws Exception {
        // 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // mysql连接串
        String jdbc = "jdbc:mysql://localhost:3306/beanequip?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";

        // 连接到数据库
        Connection conn = DriverManager.getConnection(jdbc, "root", "sea666");

        // 容器
        Statement statement = conn.createStatement();

        // sql语句
        // 插入
//        String insertSql = "Insert into student values ('2','lisi','female')";
//        statement.executeUpdate(insertSql);

        // 修改
//        String updateSql = "update student set sex = 'male' where id = '2'";

//        // 删除
//        String deleteSql = "delete from student where id = '2'";
//        statement.executeUpdate(deleteSql);
        // 查询
        String sql = "select id, name, sex from student";

        // 将sql语句上传至数据库执行
        ResultSet res = statement.executeQuery(sql);

        while (res.next()) {
            System.out.println(res.getString(1)+"," + res.getString(2)+"," + res.getString(3));
            System.out.println(res.getObject("name"));
        }
        // 关闭通道
        conn.close();
        res.close();

    }
}
