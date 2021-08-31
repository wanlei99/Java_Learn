package com.wl.builder.builders;

import com.wl.builder.cars.*;
import com.wl.builder.components.Engine;
import com.wl.builder.components.GPSNavigator;
import com.wl.builder.components.Transmission;
import com.wl.builder.components.TripComputer;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-31$
 * @Param 通用生成器接口$
 * @return $
 */
public interface Builder {
    /**
     * 设置汽车类型
     * @param cartype
     */
    void setCartype(CarType cartype);

    /**
     * @param seats
     */
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);

}
