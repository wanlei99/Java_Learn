# 适配器模式
亦称：封装器模式、Wrapper、Adapter

**适配器模式**是一种结构型设计模式，它能使接口不相同的对象能够相互合作。

适配器不仅可以转换不同格式的数据，其还有助于采用不同接口的对象之间的合作。

它的运作方式如下：

1.适配器实现与其中一个现有对象兼容的接口。

2.现有独享可以使用该接口安全地调用适配器方法。

3.适配器方法被调用后将以另一个对象兼容的格式和顺序将请求传递给该对象。
## 适配器模式结构
### 对象适配器
实现时使用了构成原则：适配器实现了其中一个对象的接口，并对另一个对象进行封装。
- 客户端（Client）是包含当前程序业务逻辑的类。
- 客户端接口（Client Interface）描述了其他类与客户端代码合作是必须遵循的协议。
- 服务（Service）中有一些功能类（通常来自第三方或遗留系统）。客户端与其接口不兼容，因此无法直接调用其功能。
- 适配器（Adapter）是一个可以同时与客户端和服务交互的类：它在失信客户端接口的同时封装了服务对象。
适配器接受客户端通过接口发起的调用，并将其转换为适用于被封装服务对象的调用。
- 客户端代码只需要通过接口与适配器交互即可，无需与具体的适配器类耦合。因此，你可以向程序中添加新类型的适配器
而无需修改已有代码。这在服务类的接口被更改或替换时很有用：你无需修改客户端代码就可以创建新的适配器类。
### 类适配器
这一实现使用了继承机制：适配器同时继承两个对象的接口。

**类适配器**不需要封装任何对象，因为它同时继承了客户端和服务的行为。适配功能在重写的方法中完成。最后生成的适配器可替代已有的客户端进行
使用。
## 适配器使用场景
#### 当你希望使用某个类，但是其接口与其他代码不兼容时，可以使用适配器类。
#### 如果你需要复用这样一些类，他们处于同一继承体系，并且他们又有额外的一些共同的方法，但是这些共同的方法
不是所有在这一继承体系中的子类所具有的共性。
## 实现方法
1. 确保至少有两个类的接口不兼容：
- 一个无法修改（通常是第三方、遗留系统或者存在众多已有已有依赖的类）的功能性服务类。
- 一个或多个将受益于使用服务类的客户端类。

2. 声明客户端接口，描述客户端如何与服务交互。

3. 创建遵循客户端接口的适配器类。所有方法暂时为空

4. 在适配器类中添加一个成员变量用于保存对于服务对象的引用。通常情况下会通过构造函数对
   该成员变量进行初始化，但有时在调用其方法时将该变量传递给适配器会更方便。

5. 一次实现适配器类客户端接口的所有方法。适配器会将实际工作委派给服务对象，自身只负责接口或数据格式的转换。   

6. 客户端必须通过客户端接口使用适配器。这样一来，你就可以在不影响客户端代码的情况下修改或扩展适配器。
## 适配器的优缺点
### 优点
- 单一职责原则——你可以将接口或数据转换代码从程序主要业务逻辑中分离。
- 开闭原则。只要客户端代码通过客户端与适配器进行交互，你就能在不修改现有客户端代码的情况下在程序中添加新类型的适配器。
### 缺点
- 代码整体复杂度增加，因为你需要增一系列接口和类。有时直接更改服务类使其与其它代码兼容会更简单。
## 代码实现
- Adapter
```java
package com.wl.structure.adapter;

/**
 * @Author Mr_wan
 * @Description 适配器 $
 * @Date $ 2021.09.02$
 * @Param $
 * @return $
 */
public class Adapter extends RoundPeg{
    private SquarePeg squarePeg;
    public Adapter(SquarePeg squarePeg){
        this.squarePeg = squarePeg;
    }
    @Override
    public double getRadius(){
        double result;
        result = (Math.sqrt(Math.pow((squarePeg.getWidth() / 2), 2) * 2));
        return result;
    }
}
```
- RoundHole
```java
package com.wl.structure.adapter;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.09.02$
 * @Param 让方钉适配圆孔——适配器$
 * @return $
 */
public class RoundHole {
    private double radius;
    public RoundHole(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    public boolean fits(RoundPeg roundPeg){
        boolean result;
        result = (this.getRadius() >= roundPeg.getRadius());
        return result;

    }
}
```
- RoundPeg
```java
package com.wl.structure.adapter;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.09.02$
 * @Param 适配器——圆钉$
 * @return $
 */
public class RoundPeg {
    private double radius;
    public RoundPeg(){}
    public RoundPeg(double radius) {
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
}
```
- SquarePeg
```java
package com.wl.structure.adapter;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.09.02$
 * @Param 适配器——方钉$
 * @return $
 */
public class SquarePeg {
    private double width;
    public SquarePeg(double width){
        this.width = width;
    }
    public double getWidth(){
        return width;
    }
    public double getSquare(){
        double result;
        result = Math.pow(this.width,2);
        return result;
    }
}
```
- Demo
```java
package com.wl.structure.adapter;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.09.02$
 * @Param 适配器——测试$
 * @return $
 */
public class Demo {
    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5);
        RoundPeg roundPeg = new RoundPeg(5);
        if (hole.fits(roundPeg)) {
            System.out.println("Round peg r5 fits round hole r5.");
        }
        SquarePeg smallSquarePeg = new SquarePeg(2);
        SquarePeg largeSquarePeg = new SquarePeg(20);
        Adapter smallAdapter = new Adapter(smallSquarePeg);
        Adapter largeAdapter = new Adapter(largeSquarePeg);
        if (hole.fits(smallAdapter)) {
            System.out.println("Square peg w2 fits round hole r5.");
        }
        if (!hole.fits(largeAdapter)){
            System.out.println("Square peg w20 does not fit into round hole r5.");
        }
    }
}
```