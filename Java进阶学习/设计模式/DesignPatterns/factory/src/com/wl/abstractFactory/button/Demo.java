package com.wl.abstractFactory.button;

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
