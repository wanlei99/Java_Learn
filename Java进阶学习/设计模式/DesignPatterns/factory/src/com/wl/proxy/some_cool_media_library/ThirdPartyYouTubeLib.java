package com.wl.proxy.some_cool_media_library;

import java.util.HashMap;

/**
 * @author WL
 * @description: 远程服务接口
 * @date 2021/9/15 14:32
 */
public interface ThirdPartyYouTubeLib {
	/**
	 * 流行
	 * @author wl
	 * @date 2021/9/15 15:15
	 * @return HashMap<Video>
	 */
	HashMap<String,Video> popularVideos() throws InterruptedException;
	/**
	 * 获取
	 * @author wl
	 * @date 2021/9/15 14:34
	 * @param videoId
	 * @return Video
	 */
	Video getVideo(String videoId) throws InterruptedException;

}
