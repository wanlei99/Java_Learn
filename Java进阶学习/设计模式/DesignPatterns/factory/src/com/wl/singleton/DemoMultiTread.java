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
