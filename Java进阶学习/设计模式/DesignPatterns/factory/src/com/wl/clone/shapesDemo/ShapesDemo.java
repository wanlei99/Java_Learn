package com.wl.clone.shapesDemo;

import com.wl.clone.shapes.Circle;
import com.wl.clone.shapes.Rectangle;
import com.wl.clone.shapes.Shape;

import java.rmi.ConnectIOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.09.01$
 * @Param 测试类$
 * @return $
 */
public class ShapesDemo {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList();
        List<Shape> shapeCopy = new ArrayList();

        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";
        shapes.add(circle);

        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        rectangle.color = "blue";
        shapes.add(rectangle);

        cloneAndCompare(shapes,shapeCopy);

    }
    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapeCopy) {
        for(Shape shape : shapes) {
            shapeCopy.add(shape.clone());
        }
        for (int a=0;a<shapes.size();a++){
            if (shapes.get(a) != shapeCopy.get(a)){
                System.out.println(":形状是不同的物体(耶!)");
                if (shapes.get(a).equals(shapeCopy.get(a))){
                    System.out.println(":他们是一样的(耶!)");
                } else {
                    System.out.println("：他们是不一样的!");
                }
            } else {
                System.out.println(":形状对象是一样的(嘘!)");
            }
        }
    }
}
