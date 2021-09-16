package com.wl.proxy;

import com.wl.proxy.downloder.YouTubeDownloader;
import com.wl.proxy.proxy.YouTubeCacheProxy;
import com.wl.proxy.some_cool_media_library.ThirdPartyYouTubeLibImpl;

/**
 * @author WL
 * @description: 测试类
 * @date 2021/9/15 16:18
 */
public class Demo {
	public static void main(String[] args) throws InterruptedException {
		YouTubeDownloader naiveDownloader = new YouTubeDownloader(new ThirdPartyYouTubeLibImpl());
		YouTubeDownloader smartDownloader = new YouTubeDownloader(new YouTubeCacheProxy());
		test(naiveDownloader);
		test(smartDownloader);
	}

	private static long test(YouTubeDownloader downloader) throws InterruptedException {
		long startTime = System.currentTimeMillis();

		downloader.renderPopularVideos();
		downloader.renderVideoPage("catzzzzzzzzz");
		downloader.renderPopularVideos();
		downloader.renderVideoPage("dancesvideoo");
		// Users might visit the same page quite often.
		downloader.renderVideoPage("catzzzzzzzzz");
		downloader.renderVideoPage("someothervid");

		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.print("Time elapsed: " + estimatedTime + "ms\n");
		return estimatedTime;
	}
}
