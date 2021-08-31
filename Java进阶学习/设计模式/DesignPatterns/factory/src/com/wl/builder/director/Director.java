package com.wl.builder.director;

import com.wl.builder.builders.Builder;
import com.wl.builder.cars.CarType;
import com.wl.builder.components.Engine;
import com.wl.builder.components.GPSNavigator;
import com.wl.builder.components.Transmission;
import com.wl.builder.components.TripComputer;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-31$
 * @Param 主管控制生成器$
 * @return $
 */
public class Director {
    /**
     * 构造运动类型的车辆
     * @param builder
     */
    public void constructSportsCar(Builder builder){
        builder.setCartype(CarType.SPORT_CAR);
        builder.setEngine(new Engine(3.0,0));
        builder.setSeats(2);
        builder.setTransmission(Transmission.SEMI_AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    /**
     * 构造城市类型得车辆
     * @param builder
     */
    public void constructCityCar(Builder builder){
        builder.setCartype(CarType.CITY_CAR);
        builder.setEngine(new Engine(2.0,0));
        builder.setSeats(4);
        builder.setGPSNavigator(new GPSNavigator());
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setTripComputer(new TripComputer());
    }

    /**
     * 构造SUV
     * @param builder
     */
    public void constructSUVCar(Builder builder){
        builder.setCartype(CarType.SUV);
        builder.setEngine(new Engine(2.8,0));
        builder.setSeats(4);
        builder.setTransmission(Transmission.MANUAL);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

}
