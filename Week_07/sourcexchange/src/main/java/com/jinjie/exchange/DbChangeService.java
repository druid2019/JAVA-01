package com.jinjie.exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/3/24 18:33
 * @Description ${description}
 */
@Service
public class DbChangeService {
    DataSource ds1;
    DataSource ds2;

    @Autowired
    public DbChangeService(DataSource ds1, DataSource ds2) {
        this.ds1 = ds1;
        this.ds2 = ds2;
    }

    public void send() {
        try (Connection connection = ds1.getConnection();
             PreparedStatement statement1 = connection.prepareStatement("INSERT INTO orders (user_id, account, order_state, pay_type, create_time, update_time) values (1,3.0,1,0,now(),now())")
        ) {
            statement1.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void receive() {
        ResultSet rs = null;
        try (Connection connection = ds2.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from orders limit 10")
        ) {
            rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getBigDecimal("account"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
