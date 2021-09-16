package com.wl.proxy.some_cool_media_library;

/**
 * @author WL
 * @description:
 * @date 2021/9/15 14:35
 */
public class Video {
	public String id;
	public String title;
	public String data;

	Video(String id, String title){
		this.id = id;
		this.data = "Random video";
		this.title = title;
	}
}
