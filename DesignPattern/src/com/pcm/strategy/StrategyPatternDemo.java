package com.pcm.strategy;

/**  
* @Package com.pcm.strategy 
* @Title: StrategyPatternDemo.java   
* @Description: 使用 Context 来查看当它改变策略 Strategy 时的行为变化。  
* @author pcm  
* @date 2018年7月16日 上午10:08:01
* @version V1.0  
*/
public class StrategyPatternDemo {
	public static void main(String[] args) {
		Context context = new Context(new OperationAdd());
		System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

		context = new Context(new OperationSubstract());
		System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

		context = new Context(new OperationMultiply());
		System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
	}

}
