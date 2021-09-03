package com.wl.structure.adapter;

/**
 * @Author Mr_wan
 * @Description 适配器 $
 * @Date $ 2021.09.02$
 * @Param $
 * @return $
 */
public class Adapter extends RoundPeg{
    private SquarePeg squarePeg;
    public Adapter(SquarePeg squarePeg){
        this.squarePeg = squarePeg;
    }
    @Override
    public double getRadius(){
        double result;
        result = (Math.sqrt(Math.pow((squarePeg.getWidth() / 2), 2) * 2));
        return result;
    }
}
