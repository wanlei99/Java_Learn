# 单例模式
单例模式是一种创建型设计模式，让你能够保证一个类只有一个实例，并提供一个访问该节点的全局节点。
## 问题
1.保证一个类只有一个实例
2.为该实例提供一个全局访问节点。
## 解决办法
所有单例的实现都包含一下两个相同的步骤：
- 将默认构造函数设为私有，防止其他对象使用单例类的``new``运算符。
- 新建一个静态构造方法作为构造函数。该函数会偷偷调用私有构造函数来创建对象，
并将其保存在一个静态成员变量中。此后所有对于该函数的调用都将返回这一缓存对象。
## 单例模式结构
1.**单例**（Singleton）类声明了一个名为``getInstance(获取实例)``的静态方法来返回其所属的一个相同实例。

单例的构造函数必须对客户端代码隐藏。调用``获取实例``方法必须是获取单例对象的唯一方式。
## 代码实现
- Singleton
```java
package com.wl.singleton;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.09.01$
 * @Param 单例模式——单线程$
 * @return $
 */
public final class Singleton {
    private static Singleton instance;
    public String value;
    private Singleton(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.value = value;
    }
    public static Singleton getInstance(String value){
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}
```
### 基础单例（单线程）
```java
package com.wl.singleton;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.09.01$
 * @Param 单例模式——测试$
 * @return $
 */
public class DemoSingleThread {
    public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");
        Singleton singleton = Singleton.getInstance("first");
        Singleton otherSing = Singleton.getInstance("other");
        System.out.println(singleton.value);
        System.out.println(otherSing.value);
    }
}
```
###基础单例（多线程）
```java
package com.wl.singleton;


/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.09.01$
 * @Param 单例模式——多线程$
 * @return $
 */
public class DemoMultiTread {
    public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");
        Thread threadFirst = new Thread(new ThreadFoo());
        Thread threadOther = new Thread(new ThreadBar());
        threadFirst.start();
        threadOther.start();
    }
    static class ThreadFoo implements Runnable {

        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("first");
            System.out.println(singleton.value);
        }
    }
    static class ThreadBar implements Runnable{

        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("other");
            System.out.println(singleton.value);
        }
    }

}
```