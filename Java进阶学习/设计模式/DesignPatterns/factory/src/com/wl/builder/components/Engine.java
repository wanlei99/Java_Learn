package com.wl.builder.components;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-31$
 * @Param 汽车引擎$
 * @return $
 */
public class Engine {
    private final double volume;
    private double mileage;
    private boolean started;

    public Engine(double volume, double mileage){
        this.volume = volume;
        this.mileage = mileage;
    }
    public void on(){
        started = true;
    }
    public void off(){
        started = false;
    }
    public boolean isStarted(){
        return started;
    }
    public void go(double mileage){
        if (started) {
            this.mileage = mileage;
        } else {
            System.out.println("Cannot go! You must start engine first!");
        }
    }
    public double getVolume(){
        return volume;
    }
    public double getMileage(){
        return mileage;
    }


}
