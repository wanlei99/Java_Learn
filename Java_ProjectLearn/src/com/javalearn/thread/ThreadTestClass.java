package com.javalearn.thread;

/**
 * @Author Mr_wan
 * @Description 线程的测试类 $
 * @Date $ 2021.8.12$
 * @Param $
 * @return $
 */
public class ThreadTestClass {
    public static void main(String[] args) {
        MyThread myThread = new MyThread("曹凯");
        myThread.start();
        DownLoad downLoad = new DownLoad("曹凯1");
        downLoad.run();
    }
}
