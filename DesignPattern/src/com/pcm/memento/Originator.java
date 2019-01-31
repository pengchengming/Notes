package com.pcm.memento;

/**  
* @Package com.pcm.memeto 
* @Title: Originator.java   
* @Description: 创建  Originator类
* @author pcm  
* @date 2018年7月11日 上午11:02:33
* @version V1.0  
*/
public class Originator {
	private String state;

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public Memento saveStateToMemento() {
		return new Memento(state);
	}

	public void getStateFromMemenTo(Memento memento) {
		state = memento.getState();
	}
}
