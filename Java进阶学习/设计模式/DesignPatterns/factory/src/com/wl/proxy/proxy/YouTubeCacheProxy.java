package com.wl.proxy.proxy;

import com.wl.proxy.some_cool_media_library.ThirdPartyYouTubeLib;
import com.wl.proxy.some_cool_media_library.ThirdPartyYouTubeLibImpl;
import com.wl.proxy.some_cool_media_library.Video;

import java.util.HashMap;

/**
 * @author WL
 * @description: 缓存代理
 * @date 2021/9/15 16:01
 */
public class YouTubeCacheProxy implements ThirdPartyYouTubeLib {
	private ThirdPartyYouTubeLib youTubeLib;
	private HashMap<String, Video> cachePopular = new HashMap<String, Video>();
	private HashMap<String, Video> cacheAll = new HashMap<String, Video>();

	public YouTubeCacheProxy(){
		this.youTubeLib = new ThirdPartyYouTubeLibImpl();
	}
	@Override
	public HashMap<String, Video> popularVideos() throws InterruptedException {
		if (cachePopular.isEmpty()){
			cachePopular = youTubeLib.popularVideos();
		} else {
			System.out.println("Retrieved list from cache");
		}
		return cachePopular;
	}

	@Override
	public Video getVideo(String videoId) throws InterruptedException {
		Video video = cacheAll.get(videoId);
		if (video == null){
			video = youTubeLib.getVideo(videoId);
			cacheAll.put(videoId,video);
		} else {
			System.out.println("Retrieved video" + videoId + "from cache!");
		}
		return video;
	}

	public void reset(){
		cachePopular.clear();
		cacheAll.clear();
	}
}
