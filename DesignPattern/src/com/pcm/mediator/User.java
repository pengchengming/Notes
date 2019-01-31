package com.pcm.mediator;

/**  
* @Package com.pcm.mediator 
* @Title: User.java   
* @Description: 创建User类  
* @author pcm  
* @date 2018年7月11日 上午10:19:11
* @version V1.0  
*/
public class User {
	private String name;

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void sendMessage(String message) {
		ChatRoom.showMessage(this, message);
	}
}
