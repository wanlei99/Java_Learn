package com.wl.bridge.remotes;

import com.wl.bridge.device.Device;

/**
 * @author WL
 * @description: 基础远程控制器
 * @date 2021/9/3 11:18
 */
public class BasicRemote implements Remote{
	Device device;
	public BasicRemote(){}
	public BasicRemote(Device device){
		this.device = device;
	}
	@Override
	public void power() {
		System.out.println("Remote: power toggle");
		if (device.isEnable()){
			device.disable();
		} else {
			device.enable();
		}
	}

	@Override
	public void volumeDown() {
		System.out.println("Remote: volume down");
		device.setVolume(device.getVolume() - 10);
	}

	@Override
	public void volumeUp() {
		System.out.println("Remote: volume up");
		device.setVolume(device.getVolume() + 10);
	}

	@Override
	public void channelDown() {
		System.out.println("Remote: channel down");
		device.setChannel(device.getChannel() - 1);
	}

	@Override
	public void channelUp() {
		System.out.println("Remote: channel up");
		device.setChannel(device.getChannel() + 1);
	}
}
