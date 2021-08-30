package com.wl.abstractFactory.product;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-30$
 * @Param 现代的桌子$
 * @return $
 */
public class ModernTable implements Table{
    @Override
    public void hasLegs() {
        System.out.println("现代的桌子！");
    }

    @Override
    public void sitOn() {
        System.out.println("现代桌子！");
    }
}
