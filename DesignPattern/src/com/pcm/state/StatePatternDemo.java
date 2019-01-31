package com.pcm.state;

/**  
* @Package com.pcm.state 
* @Title: StatePatternDemo.java   
* @Description: TODO  
* @author pcm  
* @date 2018年7月11日 下午3:13:51
* @version V1.0  
*/
public class StatePatternDemo {
	public static void main(String[] args) {
		Context context = new Context();
		StartState startState = new StartState();
		startState.doAction(context);
		System.out.println(context.getState().toString());

		StopState stopState = new StopState();
		stopState.doAction(context);

		System.out.println(context.getState().toString());

	}
}
