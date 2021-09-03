package com.wl.structure.adapter;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.09.02$
 * @Param 适配器——方钉$
 * @return $
 */
public class SquarePeg {
    private double width;
    public SquarePeg(double width){
        this.width = width;
    }
    public double getWidth(){
        return width;
    }
    public double getSquare(){
        double result;
        result = Math.pow(this.width,2);
        return result;
    }
}
