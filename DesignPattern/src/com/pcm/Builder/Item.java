package com.pcm.Builder;

/**  
* @Package com.pcm.Builder 
* @Title: Item.java   
* @Description: 创建一个表示食物条目的接口
* @author pcm  
* @date 2018年6月29日 上午9:20:42
* @version V1.0  
*/
public interface Item {
	public String name();

	public Packing packing();

	public float price();

}
