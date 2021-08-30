# 抽象工厂
在本例中， 按钮和复选框将被作为产品。 它们有两个变体： macOS 版和 Windows 版。

抽象工厂定义了用于创建按钮和复选框的接口。 而两个具体工厂都会返回同一变体的两个产品。

客户端代码使用抽象接口与工厂和产品进行交互。 同样的代码能与依赖于不同工厂对象类型的多种产品变体进行交互。
## 第一个产品层次结构
- Button
```java
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

```
- MacOSButton

```java
package com.wl.abstractFactory;

import com.wl.abstractFactory.button.Button;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-30$
 * @Param 抽象工厂类-第一个产品层次结构$
 * @return $
 */
public class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("你有一个Mac 按钮");
    }
}

```
- WindowsButton

```java
package com.wl.abstractFactory;

import com.wl.abstractFactory.button.Button;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-30$
 * @Param 抽象工厂类-第一个产品层次结构$
 * @return $
 */
public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("你有一个Windows 按钮");
    }
}
```
## 第二个产品层次结构
- CheckBox
```java
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
```
- MacOSCheckBox

```java
package com.wl.abstractFactory;

import com.wl.abstractFactory.button.CheckBox;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-30$
 * @Param 第二个产品层次结构-MacOSCheckBox$
 * @return $
 */
public class MacOSCheckBox implements CheckBox {
    @Override
    public void paint() {
        System.out.println("你有一个MacOS的复选框！");
    }
}
```
- WindowsCheckBox

```java
package com.wl.abstractFactory;

import com.wl.abstractFactory.button.CheckBox;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021=08-30$
 * @Param 第二个产品层次结构-WindowsCheckBox$
 * @return $
 */
public class WindowsCheckBox implements CheckBox {
    @Override
    public void paint() {
        System.out.println("你有一个Windows的复选框！");
    }
}
```
## 抽象工厂
- GUIFactory

```java
package com.wl.abstractFactory;

import com.wl.abstractFactory.button.Button;
import com.wl.abstractFactory.button.CheckBox;

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
```
- 具体工厂 - MacOSFactory

```java
package com.wl.abstractFactory;

import com.wl.abstractFactory.button.*;

/**
 * @Author Mr_wan
 * @Description 每个具体工厂扩展基本工厂并负责创建单一品种产品 $
 * @Date $ 2021-08-30$
 * @Param MacOS工厂实现类$
 * @return $
 */
public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacOSCheckBox();
    }
}
```
- 具体工厂 - WindowsFactory

```java
package com.wl.abstractFactory;

import com.wl.abstractFactory.button.*;

/**
 * @Author Mr_wan
 * @Description 每个具体工厂扩展基本工厂并负责创建单一品种产品$
 * @Date $ 2021-08-30$
 * @Param Windows工厂实现类$
 * @return $
 */
public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
```
## Demo

```java
package com.wl.abstractFactory;

import com.wl.abstractFactory.button.Application;
import com.wl.abstractFactory.button.GUIFactory;
import com.wl.abstractFactory.button.MacOSFactory;
import com.wl.abstractFactory.button.WindowsFactory;

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