package com.pcm.strategy;

/**  
* @Package com.pcm.strategy 
* @Title: Context.java   
* @Description: 创建Context类。  
* @author pcm  
* @date 2018年7月16日 上午10:05:05
* @version V1.0  
*/
public class Context {
	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public int executeStrategy(int num1, int num2) {
		return strategy.doOperation(num1, num2);
	}
}
