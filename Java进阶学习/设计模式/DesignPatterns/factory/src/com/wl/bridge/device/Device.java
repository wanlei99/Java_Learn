package com.wl.bridge.device;

/**
 * 所有设备的通用接口
 * @author 98710
 */
public interface Device {
    boolean isEnable();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int  percent);
    int getChannel();
    void setChannel(int channel);
    void printStatus();
}
