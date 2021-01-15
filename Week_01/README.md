2.（必做）自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。文件群里提供。

```java
public class Hello {
    static {
        System.out.println("Hello Class Initialized");
    }
}

public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            Class<?> clzz = new HelloClassLoader().findClass("Hello");
            Object instance = clzz.newInstance();
            clzz.getMethod("hello").invoke(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = prepareClazzData();
        return defineClass(name, data, 0, data.length);
    }

    private byte[] prepareClazzData() throws ClassNotFoundException {
        // 路径
        String filename = "src/main/java/com/expmple/memo/homework/first20210106/Hello.xss";
        byte[] data;
        try {
            data = loadFileData(filename);
        } catch (IOException e) {
            e.printStackTrace();
            throw  new ClassNotFoundException("xlass file not found");
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte)(255 - data[i]);
        }
        return data;
    }

    public static byte[] loadFileData(String fileName) throws IOException {
        File file = new File(fileName);
        byte[] bytes = new byte[(int) file.length()];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            fis.read(bytes);
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
        return bytes;
    }
}
```



3.（必做）画一张图，展示 Xmx、Xms、Xmn、Meta、DirectMemory、Xss 这些内存参数的关系。

![1610721518066](C:\Users\jinjun6\AppData\Roaming\Typora\typora-user-images\1610721518066.png)

```java
-Xms、-Xmx
-Xms、-Xmx分配用来设置进程堆内存的初始值和最大值。
-Xmn：新生代大小
通过这个值也可以得到老生代的大小：-Xmx减去-Xmn。
-Xss 设置每个线程可使用的内存大小，即栈的大小。如果设置过小，可能会出现栈溢出。
DirectMemory 堆外内存
-XX:MetaspaceSize、-XX:MaxMetaspaceSize:分别设置元空间最小与最大值。

-Xss1024k
意义： 设置线程栈占用内存大小。
默认值：不同的操作系统平台，其默认值不同，比较常见的为1024k。

-Xms512m
意义： 设置堆内存初始值大小。
默认值：如果未设置，初始值将是老年代和年轻代分配制内存之和。

-Xmx1024m
意义： 设置堆内存最大值。
默认值：default value is chosen at runtime based on system configuration

年轻代 = Eden(新生代) + S0 + S1
堆内存 = Young(年轻代):1/3 + Old(老年代):2/3
堆内存 = Old(老年代) + Eden + S0 + S1

-Xmn512m
意义： 设置年轻代(Young)的初始值及最大值。
默认值：堆内存的1/4（这里要记住不是最大堆内存，还是已经分配的堆内存的1/4）。

年轻代Xmn的设置为老年代存活对象的1-1.5倍。
老年代的内存大小设置为老年代存活对象的2-3倍。

-XX:NewSize=512m
意义：设置新生代(Eden)的初始值。

Meta大小相关设置
-XX:MetaspaceSize=128m
意义：初始元空间大小，达到该值就会触发垃圾收集进行类型卸载，同时GC会对该值进行调整：如果释放了大量的空间，就适当降低该值；如果释放了很少的空间，那么在不超过MaxMetaspaceSize时，适当提高该值。
-XX:MaxMetaspaceSize=256m
意义：设置元空间的最大值，默认是没有上限的，也就是说你的系统内存上限是多少它就是多少。
默认值：默认没有上限，在技术上，Metaspace的尺寸可以增长到交换空间。

比率方式设置
-XX:NewRatio=8
意义：设置老年代和年轻代的比例。比如：-XX:NewRatio=8 表示
老年代内存:年轻代内存=8:1 => 老年代占堆内存的8/9;年轻代占堆内存的1/9

-XX:SurvivorRatio=8
意义：设置新生代和存活区的比例（这里需要注意的是存活区指的是其中一个）。比如：-XX:SurvivorRatio=8 表示存活区：新生代=1：1：8新生代占年轻代的8/10,每个存活区各占年轻代的1/10。
默认值：8。

-XX:MinHeapFreeRatio=40
意义：GC后，如果发现空闲堆内存占到整个预估上限值的40%，则增大上限值。
默认值：40。

-XX:MaxHeapFreeRatio=70
GC后，如果发现空闲堆内存占到整个预估上限值的70%，则收缩预估上限值。
默认值：70。
```





