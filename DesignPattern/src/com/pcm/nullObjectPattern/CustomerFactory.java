package com.pcm.nullObjectPattern;

/**  
* @Package com.pcm.nullObjectPattern 
* @Title: CustomerFactory.java   
* @Description: 创建 CustomerFactory 类  
* @author pcm  
* @date 2018年7月16日 上午9:27:15
* @version V1.0  
*/
public class CustomerFactory {
	public static final String[] names = { "Rob", "Joe", "Julie" };

	public static AbstractCustomer getCustomer(String name) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].equalsIgnoreCase(name)) {
				return new RealCustomer(name);
			}
		}
		return new NullCustomer();
	}
}
