package com.jinjie.splitmemo;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
import org.apache.shardingsphere.infra.config.algorithm.ShardingSphereAlgorithmConfiguration;
import org.apache.shardingsphere.replicaquery.api.config.ReplicaQueryRuleConfiguration;
import org.apache.shardingsphere.replicaquery.api.config.rule.ReplicaQueryDataSourceRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.ShardingRuleConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

@SpringBootApplication
public class SplitmemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SplitmemoApplication.class, args);
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        ResultSet rs = null;
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement1 = connection.prepareStatement("insert into  orders (user_id,account,order_state,pay_type,create_time,update_time) VALUES (2,3.9,1,1,?,?);");
            PreparedStatement statement2 = connection.prepareStatement("select * from orders");
        ) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            statement1.setTimestamp(1,timestamp);
            statement1.setTimestamp(2,timestamp);
            statement1.execute();
            rs = statement2.executeQuery();
            // 写完读走的主库
            while (rs.next()) {
                System.out.println(rs.getBigDecimal("amount"));
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

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from orders");
        ) {
            rs = statement.executeQuery();
            // 读走从库
            while (rs.next()) {
                System.out.println(rs.getBigDecimal("amount"));
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

    public DataSource dataSource() {
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        HikariDataSource ds1 = new HikariDataSource();
        ds1.setJdbcUrl("jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false");
        ds1.setUsername("root");
        ds1.setPassword("sea666");
        dataSourceMap.put("master_ds", ds1);
        HikariDataSource ds2 = new HikariDataSource();
        ds2.setJdbcUrl("jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false");
        ds2.setUsername("root");
        ds2.setPassword("sea666");
        dataSourceMap.put("replica_ds", ds2);
        ShardingRuleConfiguration shardingRuleConfiguration = new ShardingRuleConfiguration();
        // 配置读写分离规则
        List<ReplicaQueryDataSourceRuleConfiguration> configurations = new ArrayList<>();
        configurations.add(new ReplicaQueryDataSourceRuleConfiguration("ds", "master_ds", Arrays.asList("replica_ds"), "load_balancer"));
        Map<String, ShardingSphereAlgorithmConfiguration> loadBalancers = new HashMap<>();
        loadBalancers.put("load_balancer", new ShardingSphereAlgorithmConfiguration("ROUND_ROBIN", new Properties()));
        ReplicaQueryRuleConfiguration ruleConfiguration = new ReplicaQueryRuleConfiguration(configurations, loadBalancers);
        // 创建DS
        try {
            return ShardingSphereDataSourceFactory.createDataSource(dataSourceMap, Arrays.asList(ruleConfiguration), new Properties());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
