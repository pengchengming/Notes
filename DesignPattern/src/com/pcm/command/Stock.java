package com.pcm.command;

/**  
* @Package com.pcm.command 
* @Title: Stock.java   
* @Description: 创建一个请求类stock  
* @author pcm  
* @date 2018年7月4日 下午4:52:12
* @version V1.0  
*/
public class Stock {
	private String name = "ABC";
	private int quantity = 10;

	public void buy() {
		System.out.println("Stock [ Name: " + name + ",Quantity: " + quantity + " ] bought");
	}

	public void sell() {
		System.out.println("Stock [ Name: " + name + ",Quantity: " + quantity + " ] sold");
	}
}
