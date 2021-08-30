package com.wl.abstractFactory.button;

/**
 * @Author Mr_wan
 * @Description 每个具体工厂扩展基本工厂并负责创建单一品种产品$
 * @Date $ 2021-08-30$
 * @Param Windows工厂实现类$
 * @return $
 */
public class WindowsFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
