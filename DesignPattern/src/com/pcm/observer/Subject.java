package com.pcm.observer;

import java.util.ArrayList;
import java.util.List;

/**  
* @Package com.pcm.observer 
* @Title: Subject.java   
* @Description: 创建Subject类  
* @author pcm  
* @date 2018年7月11日 上午11:43:38
* @version V1.0  
*/
public class Subject {
	private List<Observer> observers = new ArrayList<Observer>();
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyAllObserver();
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void notifyAllObserver() {
		for (Observer observer : observers) {
			observer.update();
		}
	}
}
