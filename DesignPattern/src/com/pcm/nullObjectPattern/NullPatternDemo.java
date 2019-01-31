package com.pcm.nullObjectPattern;

/**  
* @Package com.pcm.nullObjectPattern 
* @Title: NullPatternDemo.java   
* @Description: 使用CustomerFactory,基于客户传递的名字，来获取RealCustomer或NullCustomer对象。  
* @author pcm  
* @date 2018年7月16日 上午9:31:44
* @version V1.0  
*/
public class NullPatternDemo {
	public static void main(String[] args) {
		AbstractCustomer customer1 = CustomerFactory.getCustomer("Rob");
		AbstractCustomer customer2 = CustomerFactory.getCustomer("Bob");
		AbstractCustomer customer3 = CustomerFactory.getCustomer("Julie");
		AbstractCustomer customer4 = CustomerFactory.getCustomer("Laura");
		System.out.println("Customer");
		System.out.println(customer1.getName());
		System.out.println(customer2.getName());
		System.out.println(customer3.getName());
		System.out.println(customer4.getName());
	}
}
