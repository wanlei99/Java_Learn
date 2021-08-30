package com.wl.abstractFactory.button;

/**
 * 抽象工厂
 * @author 98710
 */
public interface GUIFactory {
    /**
     * 创建一个Button对象
     * @return Button对象
     */
    Button createButton();

    /**
     * 创建一个CheckBox对象
     * @return CheckBox对象
     */
    CheckBox createCheckBox();

}
