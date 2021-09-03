package com.wl.bridge.remotes;

/**
 * @author WL
 * @description: 所有远程控制器的通用接口
 * @date 2021/9/3 11:13
 */
public interface Remote {
	void power();
	void volumeDown();
	void volumeUp();
	void channelDown();
	void channelUp();

}
