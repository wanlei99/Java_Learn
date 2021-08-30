# Java进阶学习

## 设计模式

- 设计模式：

  设计模式是软件设计中常见问题的典型解决方案，他们就像能根据需求进行调整的预制蓝图，可用于解决代码中反复出现的设计问题。

- 设计模式包含：
  - 意图：简单描述问题和解决方案
  - 动机：展示模式的每个部分和它们之间的关系。
  - 在不同语言中的实现提供流行编程语言的代码，让读者更好的理解模式背后的思想。

- 设计模式的分类

  - 创建型模式

    - 工厂方法

      `卡车`Truck和 `轮船`Ship类都必须实现 `运输`Transport接口， 该接口声明了一个名为 `deliver`交付的方法。 每个类都将以不同的方式实现该方法： 卡车走陆路交付货物， 轮船走海路交付货物。  `陆路运输`Road­Logistics类中的工厂方法返回卡车对象， 而 `海路运输`Sea­Logistics类则返回轮船对象。调用工厂方法的代码 （通常被称为*客户端*代码） 无需了解不同子类返回实际对象之间的差别。 客户端将所有产品视为抽象的 `运输` 。 客户端知道所有运输对象都提供 `交付`方法， 但是并不关心其具体实现方式。

      ```java
      package com.wl.transport;
      
      /**
       *运输--运输工具的接口
       * @author 98710
       */
      public interface Transprot {
          /**
           * 交付方法
           */
           void deliver();
      }
      
      ```

      ```java
      /**
       * @Author Mr_wan
       * @Description 实现运输的接口 $
       * @Date $ 2021-08-30$
       * @Param 运输方式-轮船$
       * @return $
       */
      public class Ship implements Transprot{
          @Override
          public void deliver() {
              System.out.println("使用轮船运输");
          }
      }
      ```

      

      ```java
      /**
       * @Author Mr_wan
       * @Description TODO $
       * @Date $ 2021-08-30$
       * @Param 运输方式的选择-卡车$
       * @return $
       */
      public class Truck implements Transprot{
          @Override
          public void deliver() {
              System.out.println("使用卡车运输");
          }
      }
      ```

      ```java
      /**
       * @Author Mr_wan
       * @Description TODO $
       * @Date $ 2021-08-30$
       * @Param 运输$
       * @return $
       */
      public abstract class Logistics {
          /**
           * 计划运输方式
           */
         public void planDelivery(){
             Transprot transprot = createTransport();
             transprot.deliver();
         }
      
          /**
           * 创建运输工具
           */
         abstract Transprot createTransport();
      
      }
      ```

      ```java
      /**
       * @Author Mr_wan
       * @Description TODO $
       * @Date $ 2021-08-30$
       * @Param 公路运输$
       * @return $
       */
      public class RoadLogistics extends Logistics{
      
          @Override
          Transprot createTransport() {
              return new Truck();
          }
      }
      ```

      ```java
      /**
       * @Author Mr_wan
       * @Description TODO $
       * @Date $ 2021-08-30$
       * @Param 海上运输选择轮船$
       * @return $
       */
      public class SeaLogistics extends Logistics{
          @Override
          Transprot createTransport() {
              return new Ship();
          }
      }
      ```

      ```java
      /**
       * @Author Mr_wan
       * @Description TODO $
       * @Date $ 2021-08-30$
       * @Param 运输测试类$
       * @return $
       */
      public class Demo {
          private static Logistics logistics;
      
          public static void main(String[] args) {
              check();
          }
          static void check(){
              System.out.println("请选择运输的方式：海上 或 陆地");
              Scanner input = new Scanner(System.in);
              String str = input.next();
              if (str.equals("海上")){
                  logistics = new SeaLogistics();
              } else {
                  logistics = new RoadLogistics();
              }
              logistics.planDelivery();
          }
      }
      ```

      运行结果：

      ![image-20210830145740571](C:\Users\98710\AppData\Roaming\Typora\typora-user-images\image-20210830145740571.png)

    - 抽象工厂

      在本例中， 按钮和复选框将被作为产品。 它们有两个变体： macOS 版和 Windows 版。

      抽象工厂定义了用于创建按钮和复选框的接口。 而两个具体工厂都会返回同一变体的两个产品。

      客户端代码使用抽象接口与工厂和产品进行交互。 同样的代码能与依赖于不同工厂对象类型的多种产品变体进行交互。

      ```java
      第一个产品层次结构
      - Button
      package com.wl.abstractFactory;
      
      /**
       * @Author Mr_wan
       * @Description 第一个产品层次结构 $
       * @Date $ 2021-08-30$
       * @Param 抽象工厂-button类$
       * @return $
       */
      public interface Button {
          /**
           * 工厂假设你有几个系列的产品，
           * 结构成独立的类层次结构(按钮/复选框)。所有产品的
           * 同一家族有共同的接口。
           *
           * 这是按钮家族的通用界面。
           */
          void paint();
      }
      
      - MacOSButton
          
      package com.wl.abstractFactory;
      
      /**
       * @Author Mr_wan
       * @Description TODO $
       * @Date $ 2021-08-30$
       * @Param 抽象工厂类-第一个产品层次结构$
       * @return $
       */
      public class MacOSButton implements Button{
          @Override
          public void paint() {
              System.out.println("你有一个Mac 按钮");
          }
      }
      
      
      - WindowsButton
      
      package com.wl.abstractFactory;
      
      /**
       * @Author Mr_wan
       * @Description TODO $
       * @Date $ 2021-08-30$
       * @Param 抽象工厂类-第一个产品层次结构$
       * @return $
       */
      public class WindowsButton implements Button{
          @Override
          public void paint() {
              System.out.println("你有一个Windows 按钮");
          }
      }
      
      ## 第二个产品层次结构
      - CheckBox
      
      package com.wl.abstractFactory;
      
      /**
       * 第二个产品层次结构
       * 抽象工厂类- 复选框
       * @author 98710
       */
      public interface CheckBox {
          /**
           * 复选框是第二个产品，它具有与按钮相同的变体
           */
          void paint();
      }
      
      - MacOSCheckBox
      
      package com.wl.abstractFactory;
      
      /**
       * @Author Mr_wan
       * @Description TODO $
       * @Date $ 2021-08-30$
       * @Param 第二个产品层次结构-MacOSCheckBox$
       * @return $
       */
      public class MacOSCheckBox implements CheckBox{
          @Override
          public void paint() {
              System.out.println("你有一个MacOS的复选框！");
          }
      }
      
      - WindowsCheckBox
      
      package com.wl.abstractFactory;
      
      /**
       * @Author Mr_wan
       * @Description TODO $
       * @Date $ 2021=08-30$
       * @Param 第二个产品层次结构-WindowsCheckBox$
       * @return $
       */
      public class WindowsCheckBox implements CheckBox{
          @Override
          public void paint() {
              System.out.println("你有一个Windows的复选框！");
          }
      }
      
      ## 抽象工厂
      - GUIFactory
      
      package com.wl.abstractFactory;
      
      /**
       * 抽象工厂
       * @author 98710
       */
      public interface GUIFactory {
          /**
           * 创建一个Button对象
           * @return Button对象
           */
          Button createButton();
      
          /**
           * 创建一个CheckBox对象
           * @return CheckBox对象
           */
          CheckBox createCheckBox();
      
      }
      
      - 具体工厂 - MacOSFactory
      
      package com.wl.abstractFactory;
      
      /**
       * @Author Mr_wan
       * @Description 每个具体工厂扩展基本工厂并负责创建单一品种产品 $
       * @Date $ 2021-08-30$
       * @Param MacOS工厂实现类$
       * @return $
       */
      public class MacOSFactory implements GUIFactory{
          @Override
          public Button createButton() {
              return new MacOSButton();
          }
      
          @Override
          public CheckBox createCheckBox() {
              return new MacOSCheckBox();
          }
      }
      
      - 具体工厂 - WindowsFactory
      
      package com.wl.abstractFactory;
      
      /**
       * @Author Mr_wan
       * @Description 每个具体工厂扩展基本工厂并负责创建单一品种产品$
       * @Date $ 2021-08-30$
       * @Param Windows工厂实现类$
       * @return $
       */
      public class WindowsFactory implements GUIFactory{
          @Override
          public Button createButton() {
              return new WindowsButton();
          }
      
          @Override
          public CheckBox createCheckBox() {
              return new WindowsCheckBox();
          }
      }
      
      ## Demo
      
      package com.wl.abstractFactory;
      
      import java.util.Locale;
      
      /**
       * @Author Mr_wan
       * @Description TODO $
       * @Date $ 2021-08-30$
       * @Param 抽象工厂的测试类$
       * @return $
       */
      public class Demo {
          /**
           * 应用程序选择工厂类型并在运行时创建它(通常在
           * 初始化阶段)，这取决于配置或环境
           * 变量
           */
          private static Application configureApplication() {
              Application application;
              GUIFactory guiFactory;
              String osName = System.getProperty("os.name").toLowerCase();
              if (osName.contains("mac")) {
                  guiFactory = new MacOSFactory();
              } else {
                  guiFactory = new WindowsFactory();
              }
              application = new Application(guiFactory);
              return application;
          }
          public static void main(String[] args) {
              Application app = configureApplication();
              app.paint();
          }
      }
      ```

    - 生成器

    - 原型

    - 单例