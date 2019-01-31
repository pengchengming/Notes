package com.pcm.observer;

/**  
* @Package com.pcm.observer 
* @Title: HexaObserver.java   
* @Description: 创建实体观察者类HexaObserver  
* @author pcm  
* @date 2018年7月11日 下午12:58:25
* @version V1.0  
*/
public class HexaObserver extends Observer {
	public HexaObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Hex String: " + Integer.toHexString(subject.getState()));
	}

}
