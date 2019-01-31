package com.pcm.Builder;

import java.util.ArrayList;
import java.util.List;

/**  
* @Package com.pcm.Builder 
* @Title: Meal.java   
* @Description: 创建一个Meal类，带有上面定义的Item对象  
* @author pcm  
* @date 2018年6月29日 上午9:41:05
* @version V1.0  
*/
public class Meal {
	private List<Item> items = new ArrayList<Item>();

	public void addItem(Item item) {
		items.add(item);
	}

	public float getCoast() {
		float cost = 0.0f;
		for (Item item : items) {
			cost += item.price();
		}
		return cost;
	}
	
	public void showItems(){
		for (Item item : items) {
			System.out.print("Item :"+item.name());
			System.out.print(" ,Packing :"+item.packing().pack());
			System.out.println(" ,price"+item.price());
		}
	}
	
}
