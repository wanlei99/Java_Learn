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
