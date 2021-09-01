package com.wl.clone.shapes;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.09.01$
 * @Param 另一个形状$
 * @return $
 */
public class Rectangle extends Shape{
    public int width;
    public int height;
    public Rectangle(){};
    public Rectangle(Rectangle target) {
        super(target);
        if (target != null) {
            target.width = width;
            this.height = height;
        }
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }
    @Override
    public boolean equals(Object object){
        if (!(object instanceof Rectangle) || !super.equals(object)) {
            return false;
        }
        Rectangle rectangle = (Rectangle) object;
        return rectangle.width == width && rectangle.height == height;
    }
}
