学习笔记

```java
插入100万条数据
List<Orders> ordersList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            Orders orders = Orders.builder()
                    .userId(BigInteger.valueOf(i+1))
                    .account((float) i)
                    .orderState(1)
                    .payType(1).build();
            ordersList.add(orders);
        }

        long startTime = System.currentTimeMillis();
        ordermultiApplication.ordersService.batchSubmit(ordersList);
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + "ms");
```

```
2021-03-07 20:52:16.538  INFO 10532 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2021-03-07 20:52:16.538  INFO 10532 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2269 ms
2021-03-07 20:52:17.174  INFO 10532 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2021-03-07 20:52:17.498  INFO 10532 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2021-03-07 20:52:17.763  INFO 10532 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2021-03-07 20:52:17.871  INFO 10532 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2021-03-07 20:52:17.888  INFO 10532 --- [           main] com.rice.order.OrdermultiApplication     : Started OrdermultiApplication in 4.34 seconds (JVM running for 4.968)
51503ms
耗时51m
给的4G的内存
-Xms4096m -Xmx4096m
```



```java
同样的方式，改变每次提交数量,每10万条提交一次
for (int i = 0; i < 1000000; i++) {
    if ((i+1) % 100000 == 0) {
        ordermultiApplication.ordersService.batchSubmit(ordersList);
        ordersList.clear();
    }
    Orders orders = Orders.builder()
        .userId(BigInteger.valueOf(i+1))
        .account((float) i)
        .orderState(1)
        .payType(1).build();
        ordersList.add(orders);
}
```

```
2021-03-07 21:10:02.396  INFO 3652 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2021-03-07 21:10:02.722  INFO 3652 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2021-03-07 21:10:02.846  INFO 3652 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2021-03-07 21:10:02.866  INFO 3652 --- [           main] com.rice.order.OrdermultiApplication     : Started OrdermultiApplication in 4.894 seconds (JVM running for 5.812)
30120ms
耗时30m
给的4G的内存
-Xms4096m -Xmx4096m
```



```java
ShardingSphere
ShardingSphere是一套开源的分布式数据库中间件解决方案组成的生态圈，它由Sharding-JDBC、Sharding-Proxy和Sharding-Sidecar（计划中）这3款相互独立的产品组成。
ShardingSphere定位为关系型数据库中间件，旨在充分合理地在分布式的场景下利用关系型数据库的计算和存储能力，而并非实现一个全新的关系型数据库。

sharding-jdbc 定位为轻量级Java框架，在Java的JDBC层提供的额外服务。 它使用客户端直连数据库，以jar包形式提供服务，无需额外部署和依赖，可理解为增强版的JDBC驱动，完全兼容JDBC和各种ORM框架。

适用于任何基于Java的ORM框架，如：JPA, Hibernate, Mybatis, Spring JDBC Template或直接使用JDBC。 基于任何第三方的数据库连接池，如：DBCP, C3P0, BoneCP, Druid, HikariCP等。 支持任意实现JDBC规范的数据库。目前支持MySQL，Oracle，SQLServer和PostgreSQL

<dependency>
    <groupId>io.shardingsphere</groupId>
    <artifactId>sharding-jdbc-spring-boot-starter</artifactId>
    <version>3.1.0</version>
</dependency>

```

