package com.wl.abstractFactory.product;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-30$
 * @Param 维多利亚风格$
 * @return $
 */
public class VictorianChair implements Chair{
    @Override
    public void hasLegs() {
        System.out.println("维多利亚风格的椅子");
    }

    @Override
    public void sitOn() {
        System.out.println("维多利亚椅子！");
    }
}
