package com.wl.transport;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-30$
 * @Param 运输$
 * @return $
 */
public abstract class Logistics {
    /**
     * 计划运输方式
     */
   public void planDelivery(){
       Transprot transprot = createTransport();
       transprot.deliver();
   }

    /**
     * 创建运输工具
     */
   abstract Transprot createTransport();

}
