

## memory area

####方法区  
  1. 加载的类信息  
  2. 常量  
  3. 静态变量  
  4. 即时编译后的字节码  
  *[运行时常量池]*  
  OutOfMemoryError

####虚拟机栈  
  1. 线程私有  
  2. 局部变量表，操作数栈，动态链接，方法出口  
  StackOverflowError  
  OutOfMemoryError  

####本地方法栈  
  1. 本地方法使用  
  StackOverflowError  
  OutOfMemoryError  
    
####堆  
  1. 存放对象  
  2. GC  
  OutOfMemoryError  
  -Xmx, -Xms  
    
####程序计数器  
  1. 字节码行号指示器  
  2. 线程私有  
  no OOM  

####直接内存
  1. nio堆外内存  DirectByteBuffer
  OutOfMemoryError


## 对象创建过程
    
### new 
  1. 指针碰撞    连续分配
     Serial, ParNew    Compact
  2. 空闲列表    非连续分配
     CMS    Mark-Sweep
  
#####多线程内存分配同步问题：
  1. CAS + 失败重试
  2. 本地线程分配缓冲(Thread Local Allocation Buffer)TLAB
  
#####对象头
  1. 类的元数据信息
  2. 对象的哈希码
  3. 对象的GC分代年龄
  4. 是否使用偏向锁  
  
### (init)
   
  
### 对象的内存布局
  1. 对象头(Mark Word)   
     哈希码  
     GC分代年龄  
     锁状态标志  
     线程持有的锁  
     偏向线程ID 
     偏向时间戳  
  2. 实例数据  
     
  3. 对齐填充
     
### 对象的访问定位
  1. 句柄      reference -> handler -> point
  2. 直接指针  reference -> point
  
  
## 对象已死?

  1. 引用计数算法
  2. 可达性分析算法   GC Roots  -> 引用链  
    虚拟机栈中引用的对象
    方法区中静态属性引用的对象
    方法区中常量引用的对象
    本地方法栈中引用的对象

#### 引用
  1. 强引用
  2. 软引用
  3. 弱引用
  4. 虚引用
  
#### 无用的类
  1. 该类的所有实例已被回收
  2. 加载该类的ClassLoader已被回收
  3. 该类对于的java.lang.Class未被引用，任何地方无反射访问该类的方法

#### 垃圾收集算法

  1. 标记-清除算法  Mark-Sweep
  2. 复制算法
  3. 标志-整理算法
  4. 分代收集算法
  
  Eden  Survivor1  Survivor2  Old Generations
  
#### Hotspot算法

  1. GC Root分析，快照，stop the world
  2. OopMap
  3. SafePoint  方法调用，循环跳转，异常跳转
  
  抢占式中断，主动式中断
  Safe Region
  
  
#### 垃圾收集器

hopspot中多种收集器
  1. Serial 收集器  单线程
  2. ParNew 
  3. Parallel Scavenge  自适应调节策略
  4. Serial Old
  5. ParNew Old
  6. CMS(Concurrent Mark Sweep) 获取最短停顿回收时间  
    初始标记    stop the world
    并发标记
    重新标记    stop the world
    并发清除
  7. G1(Garbage First)   
  
## 内存分配与回收策略

  新对象Eden
  大对象直接进入old generations
  长期存活对象进入老年代
     MinorGC  长一岁
  动态年龄判断 
  老年代剩余空间大于yong空间，触发一次Full GC   
  

## class load

加载   zip,war,jar
验证   magic number, class (final), meta data
准备   分配内存，设置初值
解析   符号引用  替换为  直接引用
初始化 init(){static, 构造方法}
使用   
卸载   


类加载器
    

