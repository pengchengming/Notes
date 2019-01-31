package com.pcm.command;

import java.util.ArrayList;
import java.util.List;

/**  
* @Package com.pcm.command 
* @Title: Broker.java   
* @Description: 创建命令调用类Broker  
* @author pcm  
* @date 2018年7月4日 下午4:59:16
* @version V1.0  
*/
public class Broker {
	private List<Order> orderList = new ArrayList<Order>();

	public void takeOrder(Order order) {
		orderList.add(order);
	}

	public void placeOrders() {
		for (Order order : orderList) {
			order.execute();
		}
		orderList.clear();
	}
}
