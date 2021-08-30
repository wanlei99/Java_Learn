package com.wl.abstractFactory.product;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import java.util.Scanner;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-30$
 * @Param 测试类$
 * @return $
 */
public class Demo {
    public static Application configureApplication(){
        Application app;
        FurnitureFactory furnitureFactory;
        System.out.println("请输入产品类型：维多利亚 或 现代");
        Scanner product = new Scanner(System.in);
        String str = product.next();
        if(str.equals("维多利亚")){
            furnitureFactory = new VictorianFurnitureFactory();
        } else {
            furnitureFactory = new ModernFurnitureFactory();
        }
        app = new Application(furnitureFactory);
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        System.out.println("--------------");
        app.hasLegs();
        System.out.println("--------------");
        app.sitOn();
        System.out.println("--------------");
    }
}
