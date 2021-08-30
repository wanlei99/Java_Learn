package com.wl.abstractFactory.product;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-30$
 * @Param 客户端$
 * @return $
 */
public class Application {
    private Chair chair;
    private Table table;
    public Application(FurnitureFactory furnitureFactory){
        chair = furnitureFactory.createChair();
        table = furnitureFactory.createTable();
    }
    public void hasLegs(){
        chair.hasLegs();
        table.hasLegs();
    }
    public void sitOn(){
        chair.sitOn();
        table.sitOn();
    }
}
