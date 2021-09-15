package com.wl.cache.tree;

import java.awt.*;

/**
 * @author WL
 * @description: 包含多棵树共享的状态
 * @date 2021/9/13 13:21
 */
public class TreeType {
	private String name;
	private Color color;
	private String otherTreeData;

	public TreeType(String name,Color color,String otherTreeData){
		this.name = name;
		this.color = color;
		this.otherTreeData = otherTreeData;
	}
	/** 
	 * 
	 * @author yingfeng
	 * @date 2021/9/13 17:13
	 * @param g 
	 * @param x 
	 * @param y 
	 
	 */
	public void draw(Graphics g,int x,int y){
		g.setColor(Color.black);
		g.fillRect(x - 1, y , 3, 5 );
		g.setColor(color);
		g.fillRect(x - 5, y - 10, 10,10);

	}
}
