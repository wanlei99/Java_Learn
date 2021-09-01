package com.wl.builder;

import com.wl.builder.builders.CarBuilder;
import com.wl.builder.builders.CarManualBuilder;
import com.wl.builder.cars.Car;
import com.wl.builder.cars.Manual;
import com.wl.builder.director.Director;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-31$
 * @Param 测试$
 * @return $
 */
public class Demo {
    public static void main(String[] args) {
        /**
         * Director从客户端获取具体的构建器对象
         * (应用程序代码)。这是因为应用程序更好地知道是哪个
         * 使用builder来获取特定的产品
         */
        Director director = new Director();
        /**
         * Director从客户端获取具体的构建器对象
         * (应用程序代码)。这是因为应用程序更好地知道是哪个
         * 使用builder来获取特定的产品
         */
        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);
        Car car = builder.getResult();
        System.out.println("Car built:\n"+car.getCarType());

        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.constructSportsCar(manualBuilder);
        Manual manual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + manual.print());
    }


}
