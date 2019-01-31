package com.pcm.observer;

/**  
* @Package com.pcm.observer 
* @Title: OctalObserver.java   
* @Description: 创建实体观察者类OctalObserver  
* @author pcm  
* @date 2018年7月11日 下午12:58:25
* @version V1.0  
*/
public class OctalObserver extends Observer {
	public OctalObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("octal String:" + Integer.toOctalString(subject.getState()));
	}

}
