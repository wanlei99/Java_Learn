package com.wl.builder.components;

import com.wl.builder.cars.Car;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-31$
 * @Param 第四个产品特征$
 * @return $
 */
public class TripComputer {
    private Car car;
    public void setCar(Car car) {
        this.car = car;
    }
    public void showFUelLevel(){
        System.out.println("Fuel level: " + car.getFuel());
    }
    public void showStatus(){
        if(this.car.getEngine().isStarted()){
            System.out.println("Car is started!");
        } else {
            System.out.println("Car is not started!");
        }

    }
}
