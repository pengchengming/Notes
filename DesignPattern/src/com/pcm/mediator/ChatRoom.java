package com.pcm.mediator;

import java.util.Date;

/**  
* @Package com.pcm.mediator 
* @Title: ChatRoom.java   
* @Description: 创建中介类ChatRoom  
* @author pcm  
* @date 2018年7月11日 上午10:16:31
* @version V1.0  
*/
public class ChatRoom {

	public static void showMessage(User user, String message) {
		System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
	}
}
