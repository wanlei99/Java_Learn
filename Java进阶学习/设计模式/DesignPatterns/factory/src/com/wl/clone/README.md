# 原型模式
原型模式是一种创建型设计模式，使你能够复制已有对象，而又无需代码依赖它们所属的类。
## 解决方案
原型模式将克隆过程委派给被克隆的实际对象。模式为所有支持克隆的对象声明一个通用接口，该接口让你能够克隆对象，同时又无需将代码和对象所属类耦合。通常情况下，这样的接口中仅包含一个克隆方法。
所有的类对克隆方法的实现都非常相似。该方法会创建一个当前类的队形，然后将原始对象所有的成员变量值复制到新建的类中。你甚至可以复制私有成员变量，因为绝大部分编程语言都允许对象访问其同类对象的私有成员变量。
支持克隆的对象即为原型。当你的对象有几十个成员变量和几百种类型时，对其进行克隆甚至可以代替子类的构造。
## 原型模式适用的应用场景
- 如果你需要复制一些对象，同时有希望代码独立于这些队形所属的具体类，可以使用原型模式。
- 如果子类的区别仅在于其对象的初始化方式，那么你可以使用该模式来减少子类的数量。别人创建这些子类的目的可能是为了创建特定类型的对象。
## 实现方式
1.创建原型接口，在其中声明``克隆``方法。如果你已有类层次结构，则只需要在其所有类中添加该方法即可。

2.原型类必须另行定义一个以该类对象作为参数的构造函数。构造函数必须复制参数对象中所有成员变量值到新建实体中。如果你需要修稿子类，则必须调用父类构造函数，
让父类复制其私有成员变量值。

如果编程语言不支持方法重载，那么你可能需要定义一个特殊方法来复制对象数据。在构造函数中进行此类梳理比较方便，
因为它在调用``new``运算符后会马上返回结果对象。

3.因为它在调用``new``运算符调用原型版本的构造函数。主义每个
类都必须显示重写克隆方法并使用自身类名调用``new``运算符。否则，克隆方法可能会生成父类的对象。

4.你还可以创建一个中心化原型注册表，用于存储常用原型。

你可以新建一个工厂类来实现注册表，或者在原型基类中添加一个获取原型的静态方法。该方法必须能够根据客户端代码设定的条件进行搜索。搜索条件可以是简单地字符串，
或者是一组复杂的搜索参数。找到合适的原型后，注册表对原型进行克隆，并将复制生成的对象返回给客户端。

最后还要将对子类构造函数的直接调用替换为对原型祖册表工厂方法的调用。
## 原型模式地优缺点
- 优点
    - 你可以克隆对象，而无需与它们所属的具体类相耦合。
    - 你可以克隆预生成原型，避免反复运行初始化代码。
    - 你可以更方便地生成复杂对象。
    - 你可以用继承以外的方式来处理复杂对象的不同配置。
- 缺点
  - 克隆包含循环引用的复杂对象可能会非常麻烦。
## 具体代码
### shapes包
- Circle
```java
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
```
- Rectangle
```java
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
```
- Shape
```java
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
```
- ShapesDemo
```java
package com.wl.clone.shapesDemo;

import com.wl.clone.shapes.Circle;
import com.wl.clone.shapes.Rectangle;
import com.wl.clone.shapes.Shape;

import java.rmi.ConnectIOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.09.01$
 * @Param 测试类$
 * @return $
 */
public class ShapesDemo {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList();
        List<Shape> shapeCopy = new ArrayList();

        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";
        shapes.add(circle);

        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        rectangle.color = "blue";
        shapes.add(rectangle);

        cloneAndCompare(shapes,shapeCopy);

    }
    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapeCopy) {
        for(Shape shape : shapes) {
            shapeCopy.add(shape.clone());
        }
        for (int a=0;a<shapes.size();a++){
            if (shapes.get(a) != shapeCopy.get(a)){
                System.out.println(":形状是不同的物体(耶!)");
                if (shapes.get(a).equals(shapeCopy.get(a))){
                    System.out.println(":他们是一样的(耶!)");
                } else {
                    System.out.println("：他们是不一样的!");
                }
            } else {
                System.out.println(":形状对象是一样的(嘘!)");
            }
        }
    }
}
```
### cache包
- BundledShapeCache
```java
package com.wl.clone.cache;

import com.wl.clone.shapes.Circle;
import com.wl.clone.shapes.Rectangle;
import com.wl.clone.shapes.Shape;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-09-01$
 * @Param 原型工厂$
 * @return $
 */
public class BundledShapeCache {
    private Map<String, Shape> cache = new HashMap<>();
    public BundledShapeCache(){
        Circle circle = new Circle();
        circle.x = 5;
        circle.y = 7;
        circle.radius = 45;
        circle.color = "green";

        Rectangle rectangle = new Rectangle();
        rectangle.x = 6;
        rectangle.y = 9;
        rectangle.width = 8;
        rectangle.height = 10;
        rectangle.color = "blue";

        put("Blue green circle",circle);
        put("Medium blue rectangle",rectangle);

    }
    public Shape put(String key, Shape shape){
        cache.put(key, shape);
        return shape;
    }
    public Shape get(String key) {
        return cache.get(key).clone();
    }
}
```
- Demo 
```java
package com.wl.clone.cache;

import com.wl.clone.shapes.Shape;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.09.01$
 * @Param 测试$
 * @return $
 */
public class Demo {
    public static void main(String[] args) {
        //BundledShapeCache cache = new BundledShapeCache();

        BundledShapeCache cache = new BundledShapeCache();
        Shape shape1 = cache.get("Blue green circle");
        Shape shape2 = cache.get("Medium blue rectangle");
        Shape shape3 = cache.get("Medium blue rectangle");


        if (shape1 != shape2 && !shape1.equals(shape2)) {
            System.out.println("Blue green circle != Medium blue rectangle (yay!)");
        } else {
            System.out.println("Blue green circle == Medium blue rectangle (booo!)");
        }

        if (shape2 != shape3) {
            System.out.println("Medium blue rectangles are two different objects (yay!)");
            if (shape2.equals(shape3)) {
                System.out.println("And they are identical (yay!)");
            } else {
                System.out.println("But they are not identical (boo!)");
            }
        } else {
            System.out.println("Rectangle objects are the same (boo!)");
        }
    }
}
```