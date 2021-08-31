package com.wl.builder.builders;

import com.wl.builder.cars.Car;
import com.wl.builder.cars.CarType;
import com.wl.builder.components.Engine;
import com.wl.builder.components.GPSNavigator;
import com.wl.builder.components.Transmission;
import com.wl.builder.components.TripComputer;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-31$
 * @Param 汽车生成器$
 * @return $
 */
public class CarBuilder implements Builder{
    private CarType carType;
    private int seat;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;
    @Override
    public void setCartype(CarType cartype) {
        this.carType = cartype;
    }

    @Override
    public void setSeats(int seats) {
        this.seat = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }
    public Car getResult() {
        return new Car(carType, engine, seat, transmission, tripComputer, gpsNavigator);
    }
}
