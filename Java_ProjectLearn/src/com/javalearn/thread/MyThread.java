package com.javalearn.thread;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.8.21$
 * @Param 线程：集成Thread$
 * @return $
 */
public class MyThread extends Thread{
    private String name;
    public MyThread(String name) {
        this.name = name;
    }
    /**
     * 线程的执行程序
     */
    @Override
    public void run(){
        int s = 100;
        for(int i = 1; i < s; i++) {
            System.out.println(name + "下载了" + i + "次");
        }
    }
}
