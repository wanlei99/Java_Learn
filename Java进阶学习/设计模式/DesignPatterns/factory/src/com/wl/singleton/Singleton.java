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
