package com.pcm.adapter;

/**  
* @Package com.pcm.adapter 
* @Title: AudioPlayer.java   
* @Description: 创建实现了MediaPlayer接口的实体类  
* @author pcm  
* @date 2018年7月2日 下午1:41:07
* @version V1.0  
*/
public class AudioPlayer implements MediaPlayer {

	MediaAdapter mediaAdapter;

	@Override
	public void play(String audioType, String fileName) {
		// 播放mp3音乐文件的内置支持
		if (audioType.equalsIgnoreCase("mp3")) {
			System.out.println("Playing mp3 file.Name:" + fileName);
		}
		// mediaAdapter提供了播放其他文件格式的支持
		else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);

		} else {
			System.out.println("Invalid media." + audioType + " format not supported");
		}

	}

}
