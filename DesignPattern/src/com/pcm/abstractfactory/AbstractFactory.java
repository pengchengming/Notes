package com.pcm.abstractfactory;

/**  
* @Package com.pcm.abstractfactory 
* @Title: AbstractFactory.java   
* @Description: TODO  
* @author pcm  
* @date 2018年6月28日 下午3:55:34
* @version V1.0  
*/
public abstract class AbstractFactory {
	public abstract Color getColor(String color);

	public abstract Shape getShape(String shape);
}
