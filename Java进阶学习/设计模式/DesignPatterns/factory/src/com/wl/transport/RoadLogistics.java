package com.wl.transport;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-30$
 * @Param 公路运输$
 * @return $
 */
public class RoadLogistics extends Logistics{

    @Override
    Transprot createTransport() {
        return new Truck();
    }
}
