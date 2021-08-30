package com.wl.transport;

import java.util.Scanner;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-30$
 * @Param 运输测试类$
 * @return $
 */
public class Demo {
    private static Logistics logistics;

    public static void main(String[] args) {
        check();
    }
    static void check(){
        System.out.println("请选择运输的方式：海上 或 陆地");
        Scanner input = new Scanner(System.in);
        String str = input.next();
        if (str.equals("海上")){
            logistics = new SeaLogistics();
        } else {
            logistics = new RoadLogistics();
        }
        logistics.planDelivery();
    }
}
