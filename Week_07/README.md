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

