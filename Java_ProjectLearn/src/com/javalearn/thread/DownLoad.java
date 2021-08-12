package com.javalearn.thread;

/**
 * @Author Mr_wan
 * @Description 线程的操作：实现runnable接口 $
 * @Date $ 2021.8.12$
 * @Param $
 * @return $
 */
public class DownLoad implements Runnable{
    private String name;
    public DownLoad(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        int s = 100;
        for (int i = 1; i< s; i++) {
            System.out.println(name + "下载了" + i + "次");
        }

    }
}
