package com.wl.clone.cache;

import com.wl.clone.shapes.Circle;
import com.wl.clone.shapes.Rectangle;
import com.wl.clone.shapes.Shape;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-09-01$
 * @Param 原型工厂$
 * @return $
 */
public class BundledShapeCache {
    private Map<String, Shape> cache = new HashMap<>();
    public BundledShapeCache(){
        Circle circle = new Circle();
        circle.x = 5;
        circle.y = 7;
        circle.radius = 45;
        circle.color = "green";

        Rectangle rectangle = new Rectangle();
        rectangle.x = 6;
        rectangle.y = 9;
        rectangle.width = 8;
        rectangle.height = 10;
        rectangle.color = "blue";

        put("Blue green circle",circle);
        put("Medium blue rectangle",rectangle);

    }
    public Shape put(String key, Shape shape){
        cache.put(key, shape);
        return shape;
    }
    public Shape get(String key) {
        return cache.get(key).clone();
    }
}
