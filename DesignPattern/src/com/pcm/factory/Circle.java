/**
 * 
 */
package com.pcm.factory;

/**  
* @Package com.pcm.factory 
* @Title: Circle.java   
* @Description: Circle实现了Shape的接口 
* @author pcm  
* @date 2018年6月28日 下午2:38:16
* @version V1.0  
*/
public class Circle implements Shape {

	/** 
	 * Description:执行了Circle的draw方法    
	 */
	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}

}
