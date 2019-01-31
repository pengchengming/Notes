package com.pcm.mediator;

/**  
* @Package com.pcm.mediator 
* @Title: MediatorPatternDemo.java   
* @Description: 使用User对象来显示他们之间的通信  
* @author pcm  
* @date 2018年7月11日 上午10:24:13
* @version V1.0  
*/
public class MediatorPatternDemo {
	public static void main(String[] args) {
		User robert = new User("Robert");
		User john = new User("john");
		
		robert.sendMessage("hi John");
		john.sendMessage("Hello Robert");
	}
}
