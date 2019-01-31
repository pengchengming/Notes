package com.pcm.adapter;

/**  
* @Package com.pcm.adapter 
* @Title: Mp4Player.java   
* @Description: 创建实现了AdvanceMediaPlayer接口的实体类Mp4Player  
* @author pcm  
* @date 2018年7月2日 下午1:28:59
* @version V1.0  
*/
public class Mp4Player implements AdvanceMediaPlayer {

	@Override
	public void playVlc(String fileName) {
		// 什么也不做

	}

	@Override
	public void playMp4(String fileName) {
		System.out.println("Playing mp4 file .Name:"+fileName);
	}

}
