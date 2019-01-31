package com.pcm.decorator.decorator1;

/**  
* @Package com.pcm.decorator.decorator1 
* @Title: Circle.java   
* @Description: 创建实现Shape接口的实体类Rectangle  
* @author pcm  
* @date 2018年7月2日 下午5:35:09
* @version V1.0  
*/
public class Circle implements Shape{

	@Override
	public void draw() {
		System.out.println("Shape:Circle");
	}

}