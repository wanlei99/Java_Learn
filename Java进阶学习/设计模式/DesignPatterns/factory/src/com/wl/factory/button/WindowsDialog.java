package com.wl.factory.button;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-30$
 * @Param 具体实现类-工厂$
 * @return $
 */
public class WindowsDialog extends Dialog{

    @Override
    public Button createButton() {
        return new WidowsButton();
    }
}
