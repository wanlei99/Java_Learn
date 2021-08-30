package com.wl.abstractFactory.product;

/**
 * 抽象工厂
 * @author 98710
 */
public interface FurnitureFactory {
    /**
     * 创建chair对象
     * @return Chair对象
     */
    Chair createChair();
    /**
     * 创建Table对象
     * @return Table对象
     */
    Table createTable();
}
