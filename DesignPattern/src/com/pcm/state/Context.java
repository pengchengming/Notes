package com.pcm.state;

/**  
* @Package com.pcm.state 
* @Title: Context.java   
* @Description: 创建Context类  
* @author pcm  
* @date 2018年7月11日 下午2:59:54
* @version V1.0  
*/
public class Context {
	private State state;

	public Context() {
		state = null;
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}
}
