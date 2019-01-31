package com.pcm.memento;

import java.util.ArrayList;
import java.util.List;

/**  
* @Package com.pcm.memeto 
* @Title: CareTaker.java   
* @Description: 创建CareTaker类  
* @author pcm  
* @date 2018年7月11日 上午11:07:18
* @version V1.0  
*/
public class CareTaker {
	private List<Memento> mementoList = new ArrayList<Memento>();

	public void add(Memento state) {
		mementoList.add(state);
	}

	public Memento get(int index) {
		return mementoList.get(index);
	}
}
