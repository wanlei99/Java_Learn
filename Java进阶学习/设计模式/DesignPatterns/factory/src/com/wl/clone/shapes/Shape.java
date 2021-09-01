package com.wl.clone.shapes;

import java.util.Objects;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.09.01$
 * @Param 通用形状接口$
 * @return $
 */
public abstract class Shape {
    public int x;
    public int y;
    public String color;
    public Shape(){}
    public Shape(Shape target){
        if(target != null){
            this.x = target.x;
            this.y = target.y;
            this.color = target.color;
        }
    }
    /**
     * 方法克隆
     * @return
     */
    @Override
    public abstract Shape clone();
    @Override
    public boolean equals(Object object) {
        if(!(object instanceof Shape)) {
            return false;
        }
        Shape shape = (Shape) object;
        return shape.x == x && shape.y == y && Objects.equals(shape.color,color);
    }
}
