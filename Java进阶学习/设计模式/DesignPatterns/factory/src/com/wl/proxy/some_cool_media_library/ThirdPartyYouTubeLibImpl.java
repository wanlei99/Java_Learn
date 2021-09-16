package com.wl.proxy.some_cool_media_library;

import java.util.HashMap;

/**
 * @author WL
 * @description: 远程服务实现
 * @date 2021/9/15 14:35
 */
public class ThirdPartyYouTubeLibImpl implements ThirdPartyYouTubeLib{
	@Override
	public HashMap<String, Video> popularVideos() throws InterruptedException {
		connectToServer("https://www.youtube.com");
		return getRandomVideos();
	}

	@Override
	public Video getVideo(String videoId) throws InterruptedException {
		connectToServer("https://www.youtube.com/" + videoId);
		return getSomeVideo(videoId);
	}

	private int random(int max, int min){
		return min + (int) (Math.random() * ((max - min) + 1));
	}

	private void experienceNetworkLatency() throws InterruptedException {
		int randomLatency = random(5, 10);
		for (int i = 0; i < randomLatency; i++){
			Thread.sleep(100);
		}
	}

	private void connectToServer(String server) throws InterruptedException {
		System.out.println("Connecting to "+ server + "...");
		experienceNetworkLatency();
		System.out.println("Connected!" + "\n");
	}

	private HashMap<String , Video> getRandomVideos() throws InterruptedException {
		System.out.println("Downloading populars...");

		experienceNetworkLatency();
		HashMap<String, Video> hmap = new HashMap<String, Video>();
		hmap.put("catzzzzzzzzz", new Video("sadgahasgdas", "Catzzzz.avi"));
		hmap.put("mkafksangasj", new Video("mkafksangasj", "Dog play with ball.mp4"));
		hmap.put("dancesvideoo", new Video("asdfas3ffasd", "Dancing video.mpq"));
		hmap.put("dlsdk5jfslaf", new Video("dlsdk5jfslaf", "Barcelona vs RealM.mov"));
		hmap.put("3sdfgsd1j333", new Video("3sdfgsd1j333", "Programing lesson#1.avi"));

		System.out.println("Done! " + "\n");
		return hmap;
	}

	private Video getSomeVideo(String videoId) throws InterruptedException {
		System.out.println("Downloading video...");

		experienceNetworkLatency();
		Video video = new Video(videoId, "Some video title!");

		System.out.println("Done!" + "\n");
		return video;
	}
}
