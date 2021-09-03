package com.wl.bridge.remotes;

import com.wl.bridge.device.Device;

/**
 * @author WL
 * @description: 高级远程控制器
 * @date 2021/9/3 11:38
 */
public class AdvancedRemote extends BasicRemote{
	public AdvancedRemote(Device device) {
		super.device = device;
	}
	public void mute(){
		System.out.println("Remote : mute");
		device.setVolume(0);
	}

}
