jmap -heap 37888

查看进程堆内存使用情况，包括使用的GC算法、堆配置参数和各代中堆内存使用情况

```
Heap Configuration:
   MinHeapFreeRatio         = 40
   MaxHeapFreeRatio         = 70
   MaxHeapSize              = 536870912 (512.0MB)
   NewSize                  = 134217728 (128.0MB)
   MaxNewSize               = 134217728 (128.0MB)
   OldSize                  = 402653184 (384.0MB)
   NewRatio                 = 3
   SurvivorRatio            = 4
   MetaspaceSize            = 21807104 (20.796875MB)
   CompressedClassSpaceSize = 1073741824 (1024.0MB)
   MaxMetaspaceSize         = 17592186044415 MB
   G1HeapRegionSize         = 0 (0.0MB)

Heap Usage:
New Generation (Eden + 1 Survivor Space):
   capacity = 111869952 (106.6875MB)
   used     = 59681560 (56.916770935058594MB)
   free     = 52188392 (49.770729064941406MB)
   53.349053014700495% used
Eden Space:
   capacity = 89522176 (85.375MB)
   used     = 59254280 (56.50928497314453MB)
   free     = 30267896 (28.86571502685547MB)
   66.18949923647969% used
From Space:
   capacity = 22347776 (21.3125MB)
   used     = 427280 (0.4074859619140625MB)
   free     = 21920496 (20.905014038085938MB)
   1.911957592558651% used
To Space:
   capacity = 22347776 (21.3125MB)
   used     = 0 (0.0MB)
   free     = 22347776 (21.3125MB)
   0.0% used
concurrent mark-sweep generation:
   capacity = 402653184 (384.0MB)
   used     = 173979096 (165.91939544677734MB)
   free     = 228674088 (218.08060455322266MB)
   43.20817589759827% used
```

