package com.jinjie.tx;

import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/5/15 16:47
 * @Description ${description}
 */
@Service
public class DbHandleService {

    private JdbcTemplate jdbcTemplate;

    public DbHandleService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @ShardingTransactionType(value = TransactionType.XA)
    @Transactional
    public void  insertXa() {
        for (int i = 0; i < 100; i++) {
            jdbcTemplate.update("insert into orders (user_id,account,order_state,pay_type,create_time,update_time) values (101,200.6,1,0,?,?)", new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement preparedStatement) throws SQLException {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    preparedStatement.setTimestamp(1, timestamp);
                    preparedStatement.setTimestamp(2, timestamp);
                }
            });
        }
    }

    public void search() {
        jdbcTemplate.query("select * from orders where account = 200.6", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                while (resultSet.next()) {
                    System.out.println(resultSet.getBigDecimal("account"));
                }
            }
        });
    }
}
