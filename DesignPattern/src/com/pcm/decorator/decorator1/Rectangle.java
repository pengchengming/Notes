package com.pcm.decorator.decorator1;

/**  
* @Package com.pcm.decorator.decorator1 
* @Title: Rectangle.java   
* @Description: 创建实现Shape接口的实体类Rectangle  
* @author pcm  
* @date 2018年7月2日 下午5:33:51
* @version V1.0  
*/
public class Rectangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Shape:Rectangle");
	}

}
