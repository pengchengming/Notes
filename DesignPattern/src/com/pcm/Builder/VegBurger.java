package com.pcm.Builder;

/**  
* @Package com.pcm.Builder 
* @Title: VegBurger.java   
* @Description: 创建扩展了 Burger的实体类  
* @author pcm  
* @date 2018年6月29日 上午9:34:42
* @version V1.0  
*/
public class VegBurger extends Burger{

	
	@Override
	public String name() {
		return "Chicken Burger";
	}

	@Override
	public float price() {
		return 50.0f;
	}

}
