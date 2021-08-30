package com.wl.abstractFactory.button;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-30$
 * @Param 抽象工厂类-第一个产品层次结构$
 * @return $
 */
public class WindowsButton implements Button{
    @Override
    public void paint() {
        System.out.println("你有一个Windows 按钮");
    }
}
