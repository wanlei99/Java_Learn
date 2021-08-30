package com.wl.transport;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-30$
 * @Param 海上运输选择轮船$
 * @return $
 */
public class SeaLogistics extends Logistics{
    @Override
    Transprot createTransport() {
        return new Ship();
    }
}
