package com.pcm.observer;

/**  
* @Package com.pcm.observer 
* @Title: Observer.java   
* @Description: 创建Observer类。  
* @author pcm  
* @date 2018年7月11日 上午11:44:31
* @version V1.0  
*/
public abstract class Observer {
	protected Subject subject;

	public abstract void update();
}
