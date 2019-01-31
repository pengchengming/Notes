package com.pcm.observer.observer2;

import java.util.ArrayList;
import java.util.List;

/**  
* @Package com.pcm.observer.observer2 
* @Title: Subject.java   
* @Description: 被观察者  
* @author pcm  
* @date 2018年7月11日 下午2:07:57
* @version V1.0  
*/
public class Subject {
	private List<Observer> observers = new ArrayList<>();// 状态改变

	public void setMsg(String msg) {
		notifyAll(msg);
	}

	// 订阅
	public void addAttach(Observer observer) {
		observers.add(observer);
	}

	// 通知所有订阅的观察者
	private void notifyAll(String msg) {
		for (Observer observer : observers) {
			observer.update(msg);
		}
	}
}
