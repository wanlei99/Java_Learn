package com.wl.bridge;

import com.wl.bridge.device.Device;
import com.wl.bridge.device.Radio;
import com.wl.bridge.device.TV;
import com.wl.bridge.remotes.AdvancedRemote;
import com.wl.bridge.remotes.BasicRemote;

/**
 * @author WL
 * @description: 测试类
 * @date 2021/9/3 11:41
 */
public class Demo {
	public static void main(String[] args) {
		testDevice(new TV());
		testDevice(new Radio());
	}
	public static void testDevice(Device device) {
		System.out.println("Tests with basic remote");
		BasicRemote basicRemote = new BasicRemote(device);
		basicRemote.power();
		device.printStatus();

		System.out.println("Tests with advanced remote");
		AdvancedRemote advancedRemote = new AdvancedRemote(device);
		advancedRemote.power();
		advancedRemote.mute();
		device.printStatus();
	}
}
