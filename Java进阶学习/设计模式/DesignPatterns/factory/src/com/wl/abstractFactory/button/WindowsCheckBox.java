package com.wl.abstractFactory.button;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021=08-30$
 * @Param 第二个产品层次结构-WindowsCheckBox$
 * @return $
 */
public class WindowsCheckBox implements CheckBox{
    @Override
    public void paint() {
        System.out.println("你有一个Windows的复选框！");
    }
}
