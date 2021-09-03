package com.wl.structure.adapter;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.09.02$
 * @Param 让方钉适配圆孔——适配器$
 * @return $
 */
public class RoundHole {
    private double radius;
    public RoundHole(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    public boolean fits(RoundPeg roundPeg){
        boolean result;
        result = (this.getRadius() >= roundPeg.getRadius());
        return result;

    }
}
