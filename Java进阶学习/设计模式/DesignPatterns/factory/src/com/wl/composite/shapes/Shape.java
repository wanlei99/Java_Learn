package com.wl.composite.shapes;

import java.awt.*;

/**
 * @author WL
 * @description: 通用形状接口
 * @date 2021/9/6 11:03
 */
public interface Shape {
	int getX();
	int getY();
	int getWidth();
	int getHeight();
	void move(int x, int y);
	boolean isInsideBounds(int x, int y);
	void select();
	void unSelect();
	boolean isSelect();
	void paint(Graphics graphics);
}
