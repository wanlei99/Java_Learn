package com.wl.builder.cars;

import com.wl.builder.components.Engine;
import com.wl.builder.components.GPSNavigator;
import com.wl.builder.components.Transmission;
import com.wl.builder.components.TripComputer;
import org.omg.IOP.ENCODING_CDR_ENCAPS;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-31$
 * @Param 产品-car$
 * @return $
 */
public class Car {
    private final CarType carType;
    private final Engine engine;
    private final int seats;
    private final Transmission transmission;
    private final TripComputer tripComputer;
    private final GPSNavigator gpsNavigator;
    private double fuel = 0;

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }


    public Car(CarType carType,Engine engine,int seats,Transmission transmission,TripComputer tripComputer,GPSNavigator gpsNavigator){
        this.carType = carType;
        this.engine = engine;
        this.seats = seats;
        this.transmission = transmission;
        this.tripComputer = tripComputer;
        if (tripComputer != null){
            this.tripComputer.setCar(this)
;        }
        this.gpsNavigator = gpsNavigator;
    }

    public CarType getCarType() {
        return carType;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getSeats() {
        return seats;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public TripComputer getTripComputer() {
        return tripComputer;
    }

    public GPSNavigator getGpsNavigator() {
        return gpsNavigator;
    }
}
