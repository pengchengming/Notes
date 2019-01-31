package com.pcm.nullObjectPattern;

/**  
* @Package com.pcm.nullObjectPattern 
* @Title: RealCustomer
* @Description: 创建扩展了Abstract类的RealCustomer类     
* @author pcm  
* @date 2018年7月16日 上午9:21:04
* @version V1.0  
*/
public class RealCustomer extends AbstractCustomer {
	public RealCustomer(String name) {
		this.name = name;
	}

	@Override
	public boolean isNull() {
		return false;
	}

	@Override
	public String getName() {
		return name;
	}
}
