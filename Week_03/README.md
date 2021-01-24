```java
压测结果:
sb -u http://localhost:8801 -c 40 -N 30
sb -u http://localhost:8802 -c 40 -N 30
sb -u http://localhost:8803 -c 40 -N 30
```

![1610936732240](C:\Users\jinjun6\AppData\Roaming\Typora\typora-user-images\1610936732240.png)

99.9% 853ms

![1610936779916](C:\Users\jinjun6\AppData\Roaming\Typora\typora-user-images\1610936779916.png)

99.9% 146ms

![1610936842729](C:\Users\jinjun6\AppData\Roaming\Typora\typora-user-images\1610936842729.png)

99.% 106ms

|      | 单线程(requests/second) | 多线程 | 线程池 |
| ---- | :---------------------: | :----: | :----: |
| RPS  |          47.5           | 990.5  | 1581.1 |
| Max  |          853ms          | 279ms  | 1097ms |
| Min  |          24ms           |  19ms  |  19ms  |
| Avg  |         822.6ms         | 35.5ms |  22ms  |

可见:

就响应时间而言，线程池优于多线程由于单线程。