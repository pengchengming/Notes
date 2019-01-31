/**
 * 
 */
package com.pcm.factory;

/**  
* @Package com.pcm.factory 
* @Title: Rectangle.java   
* @Description: Rectangle实现了Shape的接口 
* @author pcm  
* @date 2018年6月28日 下午2:33:52
* @version V1.0  
*/
public class Rectangle implements Shape {

	/** 
	 * Description:执行Rectangle的draw的方法 
	 */
	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}

}
