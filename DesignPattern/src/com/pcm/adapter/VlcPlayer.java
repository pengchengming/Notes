/**
 * 
 */
package com.pcm.adapter;

/**  
* @Package com.pcm.adapter 
* @Title: VlcPlayer.java   
* @Description: 创建实现了AdvanceMediaPlayer接口的实体类VlcPlayer  
* @author pcm  
* @date 2018年7月2日 下午1:26:13
* @version V1.0  
*/
public class VlcPlayer implements AdvanceMediaPlayer {

	@Override
	public void playVlc(String fileName) {
		System.out.println("Playing vlc file.Name:" + fileName);
	}

	@Override
	public void playMp4(String fileName) {
		// 什么也不做
	}

}
