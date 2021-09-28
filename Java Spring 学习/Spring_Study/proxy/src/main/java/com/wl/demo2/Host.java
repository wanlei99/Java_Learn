package com.wl.demo2;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.08.27$
 * @Param 真实角色——房东$
 * @return $
 */
public class Host implements Rent{

    @Override
    public void rent() {
        System.out.println("房东要出租房子！");
    }

    @Override
    public void buyHouse() {
        System.out.println("房东要买房子！");
    }
}
