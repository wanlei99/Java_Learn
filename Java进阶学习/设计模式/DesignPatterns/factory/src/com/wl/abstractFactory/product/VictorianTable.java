package com.wl.abstractFactory.product;

/**
 * 维多利亚风格的桌子
 * @author 98710
 */
public class VictorianTable implements Table{

    @Override
    public void hasLegs() {
        System.out.println("维多利亚风格的桌子！");
    }

    @Override
    public void sitOn() {
        System.out.println("维多利亚椅子！");
    }
}
