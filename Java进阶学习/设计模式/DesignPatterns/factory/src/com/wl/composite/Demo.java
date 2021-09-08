package com.wl.composite;

import com.wl.composite.editor.ImageEditor;
import com.wl.composite.shapes.Circle;
import com.wl.composite.shapes.CompoundShape;
import com.wl.composite.shapes.Dot;
import com.wl.composite.shapes.Rectangle;

import java.awt.*;

/**
 * @author WL
 * @description: 测试
 * @date 2021/9/6 14:39
 */
public class Demo {
	public static void main(String[] args) {
		ImageEditor editor = new ImageEditor();
		editor.loadShapes(
				new Circle(10,10,10, Color.blue),
				new CompoundShape(
						new Circle(110,110,50,Color.RED),
						new Dot(160,160,Color.red)
				),
				new CompoundShape(
						new Rectangle(250,250,100,100,Color.GREEN),
						new Dot(240,240,Color.GREEN),
						new Dot(240,360,Color.GREEN),
						new Dot(360,360,Color.GREEN),
						new Dot(360,240,Color.GREEN)
				)
		);
	}
}
