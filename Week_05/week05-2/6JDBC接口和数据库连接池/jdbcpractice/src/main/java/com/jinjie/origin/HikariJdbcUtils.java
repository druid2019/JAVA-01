package com.jinjie.origin;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/2/20 21:31
 * @Description ${description}
 */
public class HikariJdbcUtils {

    public static void main(String[] args) throws Exception {
        HikariConfig config = new HikariConfig();
        String url = "jdbc:mysql://localhost:3306/beanequip?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setMaximumPoolSize(100);
        // 最小连接数
        config.setMinimumIdle(5);
        config.setIdleTimeout(10);
        config.setJdbcUrl(url);
        config.setUsername("root");
        config.setPassword("sea666");

        // 开启SQL预编译对象缓存
        config.addDataSourceProperty("cachePrepStmts", "true");
       // SQL预编译对象缓存个数 256
        config.addDataSourceProperty("prepStmtCacheSize", "256");
        // SQL预编译对象缓存个数上限 512
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "512");

        HikariDataSource dataSource = new HikariDataSource(config);
        Connection conn = dataSource.getConnection();
        System.out.println(conn);

        PreparedStatement ps = null;
        String sql = "select id, name, sex from student";
        ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString(1)+"," + rs.getString(2)+"," + rs.getString(3));
        }

        conn.close();
    }
}
