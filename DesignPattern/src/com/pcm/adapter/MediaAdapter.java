package com.pcm.adapter;

/**  
* @Package com.pcm.adapter 
* @Title: MediaAdapter.java   
* @Description: 创建实现了MediaPlayer接口的适配器类  
* @author pcm  
* @date 2018年7月2日 下午1:32:27
* @version V1.0  
*/
public class MediaAdapter implements MediaPlayer {

	AdvanceMediaPlayer advanceMediaPlayer;

	public MediaAdapter(String audioType) {
		if (audioType.equalsIgnoreCase("vlc")) {
			advanceMediaPlayer = new VlcPlayer();
		} else if (audioType.equalsIgnoreCase("mp4")) {
			advanceMediaPlayer = new Mp4Player();
		}
	}

	@Override
	public void play(String audioType, String fileName) {
		if (audioType.equalsIgnoreCase("vlc")) {
			advanceMediaPlayer.playVlc(fileName);
		} else if (audioType.equalsIgnoreCase("mp4")) {
			advanceMediaPlayer.playMp4(fileName);
		}
	}

}
