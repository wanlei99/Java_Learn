package com.wl.abstractFactory.button;

/**
 * @Author Mr_wan
 * @Description 每个具体工厂扩展基本工厂并负责创建单一品种产品 $
 * @Date $ 2021-08-30$
 * @Param MacOS工厂实现类$
 * @return $
 */
public class MacOSFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacOSCheckBox();
    }
}
