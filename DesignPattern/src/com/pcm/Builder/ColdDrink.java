package com.pcm.Builder;

/**  
* @Package com.pcm.Builder 
* @Title: Burger.java   
* @Description: 创建实现Item接口的抽象类，该类提供了默认的功能  
* @author pcm  
* @date 2018年6月29日 上午9:30:44
* @version V1.0  
*/
public abstract class ColdDrink implements Item {

	@Override
	public Packing packing() {
		return new Bottle();
	}

	@Override
	public abstract float price();

}
