package com.wl.bridge.device;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.09.03$
 * @Param 收音机$
 * @return $
 */
public class Radio implements Device{
	private boolean on = false;
	private int volume = 30;
	private int channel = 1;

	@Override
	public boolean isEnable() {
		return on;
	}

	@Override
	public void enable() {
		on = true;
	}

	@Override
	public void disable() {
		on = false;
	}

	@Override
	public int getVolume() {
		return volume;
	}

	@Override
	public void setVolume(int percent) {
		if (volume >= 100) {
			this.volume = 100;
		} else if (volume < 0){
			this.volume = 0;
		} else {
			this.volume = volume;
		}
	}

	@Override
	public int getChannel() {
		return channel;
	}

	@Override
	public void setChannel(int channel) {
		this.channel = channel;
	}

	@Override
	public void printStatus() {
		System.out.println("| ---------------------------------");
		System.out.println("| i'm radio.");
		System.out.println("| I'm "+ (on ? "enable" : "disable"));
		System.out.println("| Current volume is " + volume + "%");
		System.out.println("| Current channel is " + channel);
		System.out.println("-----------------------------------");
	}
}
