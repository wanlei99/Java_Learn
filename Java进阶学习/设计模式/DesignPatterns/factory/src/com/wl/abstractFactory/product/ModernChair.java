package com.wl.abstractFactory.product;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-30$
 * @Param 现代风格$
 * @return $
 */
public class ModernChair implements Chair{
    @Override
    public void hasLegs() {
        System.out.println("现代风格的椅子");
    }

    @Override
    public void sitOn() {
        System.out.println("现代椅子");
    }
}
