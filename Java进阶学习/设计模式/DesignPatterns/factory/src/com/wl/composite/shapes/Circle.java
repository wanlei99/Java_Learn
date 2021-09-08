package com.wl.composite.shapes;

import java.awt.*;

/**
 * @author WL
 * @description: 圆形
 * @date 2021/9/6 13:31
 */
public class Circle extends BaseShape{
	public int radius;

	public Circle(int x, int y, int radius, Color color) {
		super(x, y, color);
		this.radius = radius;
	}

	@Override
	public int getWidth() {
		return radius * 2;
	}

	@Override
	public int getHeight() {
		return radius * 2;
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		graphics.drawRect(x,y,getWidth() - 1,getHeight() - 1);
	}
}

