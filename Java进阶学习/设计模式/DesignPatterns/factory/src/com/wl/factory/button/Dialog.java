package com.wl.factory.button;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-30$
 * @Param 工厂类$
 * @return $
 */
public abstract class Dialog {
    public void renderWindows() {
        Button okButton = createButton();
        okButton.render();
    }

    /**
     * 子类将重写此方法以创建特定的按钮
     * @return
     */
    public abstract Button createButton();
}