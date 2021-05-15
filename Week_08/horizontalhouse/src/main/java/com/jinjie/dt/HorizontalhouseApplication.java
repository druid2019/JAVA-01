package com.jinjie.dt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.math.BigInteger;
import java.sql.*;

@SpringBootApplication
public class HorizontalhouseApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HorizontalhouseApplication.class, args);
        DataSource ds = context.getBean(DataSource.class);
        ResultSet rs = null;
        try (Connection cn = ds.getConnection();
             PreparedStatement st1 = cn.prepareStatement("insert into orders (user_id,account,order_state,pay_type,create_time,update_time) values (100,300.6,1,0,?,?)", Statement.RETURN_GENERATED_KEYS);
             PreparedStatement st2 = cn.prepareStatement("select * from orders");
             PreparedStatement st3 = cn.prepareStatement("update orders set pay_type = 1 where order_id = ?");
             PreparedStatement st4 = cn.prepareStatement("delete from orders where order_id = ?");
        ){
            for (int i = 0; i < 100; i++) {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                st1.setTimestamp(1, timestamp);
                st1.setTimestamp(2, timestamp);
                st1.execute();
            }
            try (ResultSet reSet = st1.getGeneratedKeys()){
                while (reSet.next()) {
                    long key = reSet.getLong(2);
                    st3.setLong(1, key);
                    st3.execute();
                    st4.setLong(1, key);
                    st4.execute();
                }
            }
            rs = st2.executeQuery();
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
