package com.wl.proxy.downloder;

import com.wl.proxy.some_cool_media_library.ThirdPartyYouTubeLib;
import com.wl.proxy.some_cool_media_library.Video;

import java.util.HashMap;

/**
 * @author WL
 * @description: 媒体下载应用
 * @date 2021/9/15 16:13
 */
public class YouTubeDownloader {
	private ThirdPartyYouTubeLib api;

	public YouTubeDownloader(ThirdPartyYouTubeLib api){
		this.api = api;
	}

	public void renderVideoPage(String videoId) throws InterruptedException {
		Video video = api.getVideo(videoId);
		System.out.println("\n-------------------------------");
		System.out.println("Video page (imagine fancy HTML)");
		System.out.println("ID: " + video.id);
		System.out.println("Title: " + video.title);
		System.out.println("Video: " + video.data);
		System.out.println("-------------------------------\n");
	}
	public void renderPopularVideos() throws InterruptedException {
		HashMap<String, Video> list = api.popularVideos();
		System.out.println("\n-------------------------------");
		System.out.println("Most popular videos on YouTube (imagine fancy HTML)");
		for (Video video : list.values()) {
			System.out.println("ID: " + video.id + " / Title: " + video.title);
		}
		System.out.println("-------------------------------\n");
	}
}
