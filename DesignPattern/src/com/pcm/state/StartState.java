package com.pcm.state;

/**  
* @Package com.pcm.state 
* @Title: StartState.java   
* @Description: 创建实现接口的实体类State  
* @author pcm  
* @date 2018年7月11日 下午3:09:59
* @version V1.0  
*/
public class StartState implements State {
	public void doAction(Context context) {
		System.out.println("Player is in start state");
		context.setState(this);
	};

	public String toString() {
		return "Start State";
	}
}
