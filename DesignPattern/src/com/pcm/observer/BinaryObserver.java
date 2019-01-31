package com.pcm.observer;

/**  
* @Package com.pcm.observer 
* @Title: BinaryObserver.java   
* @Description: 创建实体观察者类BinaryObserver  
* @author pcm  
* @date 2018年7月11日 下午12:58:25
* @version V1.0  
*/
public class BinaryObserver extends Observer {
	public BinaryObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Binary String:" + Integer.toBinaryString(subject.getState()));
	}

}
