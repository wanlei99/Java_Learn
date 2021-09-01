package com.wl.clone.shapes;

import java.util.Objects;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.09.01$
 * @Param 简单形状——圆$
 * @return $
 */
public class Circle extends Shape{
    public int radius;
    public Circle(){};
    public Circle(Circle target){
        super(target);
        if (target != null){
            this.radius = target.radius;
        }
    }
    @Override
    public Shape clone() {
        return new Circle(this);
    }
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Circle) || !super.equals(object)) {
            return false;
        }
        Circle shape = (Circle) object;
        return shape.radius == radius;
    }

}
