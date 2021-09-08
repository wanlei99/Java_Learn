package com.wl.composite.shapes;

import java.awt.*;

/**
 * @author WL
 * @description: 提供基本功能的抽象形状
 * @date 2021/9/6 13:18
 */
public class BaseShape implements Shape{
	public int x;
	public int y;
	public Color color;
	private boolean select = false;

	BaseShape(int x, int y, Color color){
		this.x = x;
		this.y = y;
		this.color = color;
	}
	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getWidth() {
		return 0;
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public void move(int x, int y) {
		this.x += x;
		this.y += y;
	}

	@Override
	public boolean isInsideBounds(int x, int y) {
		return x > getX() && x < (getX() + getWidth()) &&
				y > getY() && y < (getY() + getHeight());
	}

	@Override
	public void select() {
		select = true;
	}

	@Override
	public void unSelect() {
		select = false;
	}

	@Override
	public boolean isSelect() {
		return select;
	}

	void enableSelectionStyle(Graphics graphics){
		graphics.setColor(Color.LIGHT_GRAY);

		Graphics2D g2 = (Graphics2D) graphics;
		float[] dash1 = {2.0f};
		g2.setStroke(new BasicStroke(1.0f,
				BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_MITER,
				2.0f, dash1, 0.0f));
	}

	void disableSelectionStyle(Graphics graphics){
		graphics.setColor(color);
		Graphics2D g2 = (Graphics2D) graphics;
		g2.setStroke(new BasicStroke());
	}
	@Override
	public void paint(Graphics graphics) {
		if (isSelect()){
			enableSelectionStyle(graphics);
		} else {
			disableSelectionStyle(graphics);
		}
	}
}
