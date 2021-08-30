package com.wl.transport;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-30$
 * @Param 运输方式-轮船$
 * @return $
 */
public class Ship implements Transprot{
    @Override
    public void deliver() {
        System.out.println("使用轮船运输");
    }
}
