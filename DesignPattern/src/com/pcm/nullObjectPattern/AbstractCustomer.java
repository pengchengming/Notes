package com.pcm.nullObjectPattern;

/**  
* @Package com.pcm.nullObjectPattern 
* @Title: AbstractCustomer.java   
* @Description: 创建一个抽象类AbstractCustomer  
* @author pcm  
* @date 2018年7月16日 上午9:13:37
* @version V1.0  
*/
public abstract class AbstractCustomer {
	protected String name;

	public abstract boolean isNull();

	public abstract String getName();
}
