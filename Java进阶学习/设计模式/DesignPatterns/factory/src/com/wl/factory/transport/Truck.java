package com.wl.factory.transport;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-30$
 * @Param 运输方式的选择-卡车$
 * @return $
 */
public class Truck implements Transprot{
    @Override
    public void deliver() {
        System.out.println("使用卡车运输");
    }
}
