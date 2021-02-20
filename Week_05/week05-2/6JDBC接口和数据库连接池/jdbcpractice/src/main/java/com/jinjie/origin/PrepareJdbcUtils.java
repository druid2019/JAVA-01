package com.jinjie.origin;

import org.springframework.data.relational.core.sql.SQL;

import java.sql.*;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/2/20 20:10
 * @Description ${description}
 */
public class PrepareJdbcUtils {

    public static void main(String[] args) throws Exception {
        // 获取数据库连接对象
        Connection conn = getConnection();
        // 通过连接创建数据库执行对象
        PreparedStatement ps = null;
        // 为查询的结果集准备接收对象
        ResultSet rs = null;
        // 查询
        String querySql = "select id, name, sex from student where id = ?";
        ps = conn.prepareStatement(querySql);
        ps.setObject(1, "1");
        getInfo(ps, rs);
//        // 新增
//        String sqlStatement = "insert into student values(?,?,?)";
//        ps = conn.prepareStatement(sqlStatement);
//        ps.setObject(1, "2");
//        ps.setObject(2, "lisi");
//        ps.setObject(3, "female");
//        System.out.println("插入执行结果：" + update(ps, sqlStatement));
        // 修改
//        sqlStatement = "update student set sex = ? where id = ?";
//        ps = conn.prepareStatement(sqlStatement);
//        ps.setObject(1, "male");
//        ps.setObject(2, "2");
//        System.out.println("修改执行结果：" + update(ps, sqlStatement));
        // 删除
//        sqlStatement = "delete from student where id = ?";
//        ps = conn.prepareStatement(sqlStatement);
//        ps.setObject(1, "2");
//        System.out.println("修改执行结果：" + update(ps, sqlStatement));

        // 批处理
        String sqlStatement = "insert into student values(?,?,?)";
        ps = conn.prepareStatement(sqlStatement);
        for (int i = 1; i < 11; i++) {
            // 赋值
            ps.setObject(1,i+1);
            ps.setObject(2,"zhangsan" + (i + 1));
            ps.setObject(3,"female");
            // 添加
            ps.addBatch();
        }
        long start = System.currentTimeMillis();
        ps.executeBatch();
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");

        closeConnection(conn,ps,rs);
    }

    /**
     * 获取数据库连接对象
     * @return  
     * @create  
     */
    public static Connection getConnection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/beanequip?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
        String user = "root";
        String password = "sea666";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("获取数据库连接异常，请检查配置数据");
        }
        return conn;
    }

    /**
     * 关闭连接
     * @param conn
     * @param sta
     * @param rs
     * @return
     * @create
     */
    public static void closeConnection(Connection conn, Statement sta, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (sta != null) {
                sta.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询
     * @param sta
     * @param rs
     * @return  
     * @create  
     */
    private static void getInfo(PreparedStatement sta, ResultSet rs) throws Exception{
        rs = sta.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString(1)+"," + rs.getString(2)+"," + rs.getString(3));
        }
    }

    /**
     * 修改
     * @param sta 
     * @param sql
     * @return  
     * @create  
     */
    public static int update(PreparedStatement sta, String sql) throws SQLException{
        return sta.executeUpdate();
    }
}
