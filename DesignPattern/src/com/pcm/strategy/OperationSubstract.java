package com.pcm.strategy;

/**  
* @Package com.pcm.strategy 
* @Title: OperationSubstract.java   
* @Description: 创建实现接口的实体类OperationSubstract  
* @author pcm  
* @date 2018年7月16日 上午10:01:17
* @version V1.0  
*/
public class OperationSubstract implements Strategy {

	@Override
	public int doOperation(int num1, int num2) {
		return num1 - num2;
	}

}
