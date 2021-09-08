package com.wl.composite.shapes;

import java.awt.*;

/**
 * @author WL
 * @description: 三角形
 * @date 2021/9/6 13:39
 */
public class Rectangle extends BaseShape{
	public int width;
	public int height;

	public Rectangle(int x, int y, int width, int height, Color color) {
		super(x, y, color);
		this.height = height;
		this.width = width;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		graphics.drawRect(x,y,getWidth() - 1,getHeight() - 1);
	}
}
