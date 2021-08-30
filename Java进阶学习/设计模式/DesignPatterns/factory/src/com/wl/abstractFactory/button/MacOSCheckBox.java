package com.wl.abstractFactory.button;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-30$
 * @Param 第二个产品层次结构-MacOSCheckBox$
 * @return $
 */
public class MacOSCheckBox implements CheckBox{
    @Override
    public void paint() {
        System.out.println("你有一个MacOS的复选框！");
    }
}
