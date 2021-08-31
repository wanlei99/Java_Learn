package com.wl.builder.components;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021-08-31$
 * @Param 第二个产品特征-只是汽车的另一个特征。$
 * @return $
 */
public class GPSNavigator {
    private String route;
    public GPSNavigator(){
        this.route = "221b, Baker Street, London  to Scotland Yard, 8-10 Broadway, London";
    }
    public GPSNavigator(String manualRoute) {
        this.route = manualRoute;
    }
    public String getRoute(){
        return route;
    }
}
