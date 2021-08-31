package com.wl.factory.button;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-30$
 * @Param 测试类$
 * @return $
 */
public class Demo {
    private static Dialog dialog;
    public static void main(String[] args) {
        config();
        runBusinessLogic();
        dialog = new HtmlDialog();
        dialog.renderWindows();
    }
    static void config(){
        if(System.getProperty("os.name").equals("Windows 10")){
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }
    static void runBusinessLogic(){
        dialog.renderWindows();
    }
}
