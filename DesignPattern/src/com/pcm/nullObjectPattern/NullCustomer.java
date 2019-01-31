package com.pcm.nullObjectPattern;

/**  
* @Package com.pcm.nullObjectPattern 
* @Title: NullCustomer.
* @Description: 创建扩展了Abstract类的NullCustomer类     
* @author pcm  
* @date 2018年7月16日 上午9:21:04
* @version V1.0  
*/
public class NullCustomer extends AbstractCustomer {

	@Override
	public boolean isNull() {
		return true;
	}

	@Override
	public String getName() {
		return "Not Available in Customer Database";
	}
}
