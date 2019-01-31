package com.pcm.memento;

/**  
* @Package com.pcm.memeto 
* @Title: Memento.java   
* @Description: 创建Memento类  
* @author pcm  
* @date 2018年7月11日 上午11:00:03
* @version V1.0  
*/
public class Memento {
	private String state;

	public Memento(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}
}
