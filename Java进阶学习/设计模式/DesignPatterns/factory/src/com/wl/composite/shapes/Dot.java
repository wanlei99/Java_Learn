package com.wl.composite.shapes;

import java.awt.*;

/**
 * @author WL
 * @description: 点
 * @date 2021/9/6 13:26
 */
public class Dot extends BaseShape{
	private final int DOT_SIZE = 3;
	public Dot(int x, int y, Color color){
		super(x,y,color);
	}

	@Override
	public int getWidth() {
		return DOT_SIZE;
	}

	@Override
	public int getHeight() {
		return DOT_SIZE;
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		graphics.fillRect(x - 1,y - 1,getWidth(),getHeight());
	}
}
