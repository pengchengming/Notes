package com.pcm.adapter;

/**  
* @Package com.pcm.adapter 
* @Title: AdapterPatternDemo.java   
* @Description: 使用 AudioPlayer 来播放不同类型的音频格式。  
* @author pcm  
* @date 2018年7月2日 下午1:56:30
* @version V1.0  
*/
public class AdapterPatternDemo {
	public static void main(String[] args) {
		AudioPlayer audioPlayer = new AudioPlayer();
		audioPlayer.play("mp3", "beyond the horizon.mp3");
		audioPlayer.play("mp4", "alone.mp4");
		audioPlayer.play("vlc", "far far away.vlc");
		audioPlayer.play("avi", "mind me.avi");
	}
}
