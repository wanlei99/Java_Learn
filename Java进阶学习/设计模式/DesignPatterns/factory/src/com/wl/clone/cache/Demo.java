package com.wl.clone.cache;

import com.wl.clone.shapes.Shape;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.09.01$
 * @Param 测试$
 * @return $
 */
public class Demo {
    public static void main(String[] args) {
        //BundledShapeCache cache = new BundledShapeCache();

        BundledShapeCache cache = new BundledShapeCache();
        Shape shape1 = cache.get("Blue green circle");
        Shape shape2 = cache.get("Medium blue rectangle");
        Shape shape3 = cache.get("Medium blue rectangle");


        if (shape1 != shape2 && !shape1.equals(shape2)) {
            System.out.println("Blue green circle != Medium blue rectangle (yay!)");
        } else {
            System.out.println("Blue green circle == Medium blue rectangle (booo!)");
        }

        if (shape2 != shape3) {
            System.out.println("Medium blue rectangles are two different objects (yay!)");
            if (shape2.equals(shape3)) {
                System.out.println("And they are identical (yay!)");
            } else {
                System.out.println("But they are not identical (boo!)");
            }
        } else {
            System.out.println("Rectangle objects are the same (boo!)");
        }
    }
}
