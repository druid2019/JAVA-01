**Week02 作业题目（周三）：**

1.使用 GCLogAnalysis.java 自己演练一遍串行 / 并行 /CMS/G1 的案例。

a.串行:

java -XX:+UseSerialGC -Xms512m -Xmx512m -Xloggc:gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

![1611037328222](C:\Users\jinjun6\AppData\Roaming\Typora\typora-user-images\1611037328222.png)

demo.log

![1611037403496](C:\Users\jinjun6\AppData\Roaming\Typora\typora-user-images\1611037403496.png)

 串行收集器：DefNew：是使用-XX:+UseSerialGC（新生代，老年代都使用串行回收收集器）

new generation:新生代

tenured generation:老年代

b.并行GC

java -XX:+UseParallelGC -Xms512m -Xmx512m -Xloggc:gc.demobx.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

![1611039138966](C:\Users\jinjun6\AppData\Roaming\Typora\typora-user-images\1611039138966.png)

gc.demobx.log

![1611039312775](C:\Users\jinjun6\AppData\Roaming\Typora\typora-user-images\1611039312775.png)

如果不设置xmx/xms,系统默认分配约2.5g的堆内存。

c.CMS gc

java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -Xloggc:gc.democms.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

![1611280750719](C:\Users\jinjun6\AppData\Roaming\Typora\typora-user-images\1611280750719.png)

![1611280655694](C:\Users\jinjun6\AppData\Roaming\Typora\typora-user-images\1611280655694.png)

```java
Intitial Mark(初始标记)
[1 CMS-initial-mark: 200480K(349568K)] 218172K(506816K), 0.0006261 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]

Concurrent Mark(并发标记)
[Times: user=0.03 sys=0.01, real=0.01 secs]

Concurrent Preclean(并发预清理)
[Times: user=0.00 sys=0.00, real=0.00 secs]

Final Remark(最终标记)
[YG occupancy: 24558 K (157248 K)]2021-01-19T16:45:48.030+0800: 1.002: [Rescan (parallel) , 0.0006216 secs]2021-01-19T16:45:48.031+0800: 1.002: [weak refs processing, 0.0000384 secs]2021-01-19T16:45:48.031+0800: 1.002: [class unloading, 0.0003004 secs]2021-01-19T16:45:48.031+0800: 1.003: [scrub symbol table, 0.0005099 secs]2021-01-19T16:45:48.032+0800: 1.003: [scrub string table, 0.0002610 secs][1 CMS-remark: 329625K(349568K)] 354184K(506816K), 0.0018321 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]

Concurrent Sweep(并发清除)
[Times: user=0.00 sys=0.00, real=0.00 secs]

Concurrent Reset(并发重置)
[Times: user=0.01 sys=0.00, real=0.00 secs]
```



java -XX:+UseConcMarkSweepGC -Xms4g -Xmx4g -Xloggc:gc.democms.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

改为4g，则显示为:

![1611281027796](C:\Users\jinjun6\AppData\Roaming\Typora\typora-user-images\1611281027796.png)

![1611045467995](C:\Users\jinjun6\AppData\Roaming\Typora\typora-user-images\1611045467995.png)

堆内存改为4G的时候并没有显示这些过程。

d. G1 GC

java -XX:+UseG1GC -Xms512m -Xmx512m -Xloggc:gc.demog1.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

![1611282043372](C:\Users\jinjun6\AppData\Roaming\Typora\typora-user-images\1611282043372.png)

![1611047919625](C:\Users\jinjun6\AppData\Roaming\Typora\typora-user-images\1611047919625.png)



```
Evacuation Pause: young (纯年轻代模式转移暂停)
Concurrent Marking (并发标记)
1.Initial Mark (初始标记)
2.Root Region Scan (Root区扫描)
3.Concurrent Mark (并发标记)
4.Remark (再次标记)
[GC remark 2021-01-19T17:08:11.832+0800: 0.551: [Finalize Marking, 0.0012620 secs] 2021-01-19T17:
08:11.833+0800: 0.552: [GC ref-proc, 0.0025141 secs] 2021-01-19T17:08:11.835+0800: 0.555: [Unloading, 0.0020007 secs], 0.0070879 secs]

5.Cleanup (清理)
Evacuation Pause (mixed) (转移暂停:混合模式)
[GC Worker Start (ms): Min: 602.7, Avg: 602.9, Max: 603.3, Diff: 0.6]

Full GC (Allocation Failure)
```

![1611053156406](C:\Users\jinjun6\AppData\Roaming\Typora\typora-user-images\1611053156406.png)

设置成4g

![1611053137117](C:\Users\jinjun6\AppData\Roaming\Typora\typora-user-images\1611053137117.png)



java -XX:+UseG1GC -Xms4g -Xmx4g -XX:+PrintGC -XX:+PrintGCDateStamps GCLogAnalysis

java -XX:+UseG1GC -Xms4g -Xmx4g -Xloggc:gc.demog1gc4g.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

![1611286042695](C:\Users\jinjun6\AppData\Roaming\Typora\typora-user-images\1611286042695.png)



2.使用压测工具（wrk 或 sb），演练 gateway-server-0.0.1-SNAPSHOT.jar 示例。

wrk的安装:

```
CentOs下的安装:
sudo yum groupinstall 'Development Tools'
sudo yum install openssl-devel
sudo yum install git
git clone https://github.com/wg/wrk.git wrk
cd wrk
make
# 把生成的 wrk 移到一个 PATH 目录下面, 比如
sudo cp wrk /usr/local/bin
```

java -Xmx1g -Xms1g -XX:+UseG1GC -XX:MaxGCPauseMillis=100 -jar gateway-server-0.0.1-SNAPSHOT.jar

java -Xmx1g -Xms1g -XX:-UseAdaptiveSizePolicy -XX:+UseParallelGC -jar gateway-server-0.0.1-SNAPSHOT.jar

```
 MaxHeapSize              = 1073741824 (1024.0MB)
 NewSize                  = 357564416 (341.0MB)
 MaxNewSize               = 357564416 (341.0MB)
 OldSize                  = 716177408 (683.0MB)
```



压测：

sb -u http://10.199.107.50:8803 -c 40 -N 30

```java
-c --concurrency (Default: 1) 并发请求数
-n, --numberOfRequests (Default: 100) 请求数量
-m, --method (Default: GET) HTTP Method
-u, --url 请求地址，也就是需要压测的地址
-v,–verbose：输出详细
-h, --headers：输出HTTP Header
-k, --cookies：输出cookie
-q, --onlyRequest：仅输出请求信息
```

wrk -c 40 -d30s http://10.199.107.50:8801

```java
Usage: wrk <options> <url>                           
  Options:                                           
    -c, --connections <N>  Connections to keep open  
    -d, --duration    <T>  Duration of test          
    -t, --threads     <N>  Number of threads to use                             
    -s, --script      <S>  Load Lua script file      
    -H, --header      <H>  Add header to request     
        --latency          Print latency statistics  
        --timeout     <T>  Socket/request timeout    
    -v, --version          Print version details     
                                                
  Numeric arguments may include a SI unit (1k, 1M, 1G)
  Time arguments may include a time unit (2s, 2m, 2h)
Usage: wrk <options> <url>
    -c, --connections <N>  跟服务器建立并保持的TCP连接数量 
    -d, --duration    <T>  压测时间          
    -t, --threads     <N>  使用多少个线程进行压测，压测时，是有一个主线程来控制我们设置的n个子线程间调度
```

wrk -c 40 -d 30s http://10.19.165.249:8088/api/hello

```
Running 30s test @ http://10.19.165.249:8088/api/hello
  2 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency   435.92us    0.98ms  41.79ms   95.24%
    Req/Sec    65.84k    10.29k   73.83k    93.50%
  3929944 requests in 30.00s, 469.20MB read
Requests/sec: 130991.95
Transfer/sec:     15.64MB
```

wrk -c 40 -d 30s http://10.19.165.249:8088/test

```
Running 30s test @ http://10.19.165.249:8088/test
  2 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     6.30ms   12.34ms 248.92ms   99.06%
    Req/Sec     3.80k   278.97     4.86k    91.95%
  225703 requests in 30.00s, 56.87MB read
  Non-2xx or 3xx responses: 225703
Requests/sec:   7522.86
Transfer/sec:      1.90MB
```



4.根据上述自己对于 1 和 2 的演示，写一段对于不同 GC 和堆内存的总结。

```java
串行、 并行、CMS、G1属于四种不同的垃圾收集器，每种垃圾都有其独特的优缺点。
串行 +UseSerialGC
 串行收集器是最简单的一种，它主要是为单线程环境和小型堆而设计的。该收集器会在其工作时冻结所有应用程序线程，这使它无法出于所有意图和目的在服务器环境中使用。

并行/吞吐量收集器 +UseParallelGC
 这是JVM的默认收集器。它的最大优点是使用多个线程来扫描并压缩堆。 并行收集器的不利之处在于，在执行次要或完全GC收集时，它将停止应用程序线程。并行收集器最适合可以容忍应用程序暂停并试图优化以减少由收集器引起的CPU开销的应用程序。
 
CMS收集器(current-mark-sweep) +UseConcMarkSweepGC
以获取最短回收停顿时间【也就是指Stop The World的停顿时间】为目标，多数应用于互联网站或者B/S系统的服务器端上。其中“Concurrent”并发是指垃圾收集的线程和用户执行的线程是可以同时执行的。
CMS是基于“标记-清除”算法实现的，整个过程分为4个步骤：
1、初始标记（CMS initial mark）。
2、并发标记（CMS concurrent mark）。
3、重新标记（CMS remark）。
4、并发清除（CMS concurrent sweep）。
优点：并发收集、低停顿。
缺点：
1、CMS收集器对CPU资源非常敏感。
2、CMS收集器无法处理浮动垃圾
3、收集结束时会有大量空间碎片产生，空间碎片过多时，将会给大对象分配带来很大麻烦，往往出现老年代还有很大空间剩余，但是无法找到足够大的连续空间来分配当前对象，不得不提前进行一次Full GC。

G1 gc  +UseG1GC
 传统的GC收集器将连续的内存空间划分为新生代、老年代和永久代（JDK 8去除了永久代，引入了元空间Metaspace），这种划分的特点是各代的存储地址（逻辑地址）是连续的。
 G1垃圾收集器相比于其他而言，最大的区别在于取消了年轻代、老年代的物理划分，取而代之的是将堆划分为若干个区域(Region),这些区域中包含有了逻辑上的年轻代、老年代区域。
 G1的各代存储地址是不连续的，每一代都使用了n个不连续的大小相同的Region，每个Region占有一块连续的虚拟内存地址。
 这样做的好处就是，我们无需单独的空间对每个代进行设置了，不用担心每个代内存是否足够。
 G1提供了两种GC模式，Young GC和Mixed GC，两种都是完全Stop The World的。为jdk9以后默认的gc策略。
 
 -XX:MaxGCPauseMillis=200m：是G1中最重要的参数之一，表示期望GC过程中停顿的时间，这里表示设置200ms；
 
根据以上测试，可以发现:
 串行、并行、cms下的伊甸区和survivor区比例为8:1:1、老年代和年轻代比例为2:1,并行则分别为1:1:1和3:1。伊甸区使用最高的是串行下，生成对象最多的是并行下。cms下增加内存，生成对象反而减少，同时伊甸区和老年代使用率也偏低。g1gc取消了年轻代、老年代的物理划分，取而代之的是将堆划分为若干个区域(Region),随着堆内存增大，生成对象也变多，region区的划分空间也翻倍了。
```



**Week02 作业题目（周日）：**

5.写一段代码，使用 HttpClient 或 OkHttp 访问 [http://localhost:8801 ](http://localhost:8801/)

