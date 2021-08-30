package com.wl.abstractFactory.button;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-30$
 * @Param 客户端代码$
 * @return $
 */
public class Application {
    private Button button;
    private CheckBox checkBox;
    public Application(GUIFactory guiFactory){
        button = guiFactory.createButton();
        checkBox = guiFactory.createCheckBox();
    }
    public void paint(){
        button.paint();
        checkBox.paint();
    }

}
