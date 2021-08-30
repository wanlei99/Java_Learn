package com.wl.abstractFactory.button;

/**
 * @Author Mr_wan
 * @Description 第一个产品层次结构 $
 * @Date $ 2021-08-30$
 * @Param 抽象工厂-button类$
 * @return $
 */
public interface Button {
    /**
     * 工厂假设你有几个系列的产品，
     * 结构成独立的类层次结构(按钮/复选框)。所有产品的
     * 同一家族有共同的接口。
     *
     * 这是按钮家族的通用界面。
     */
    void paint();
}
