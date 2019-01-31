package com.pcm.Prototype;

/**  
* @Package com.pcm.Prototype 
* @Title: Rectangle.java   
* @Description: 创建扩展了 Shape抽象类的实体类Rectangle
* @author pcm  
* @date 2018年7月2日 上午10:01:45
* @version V1.0  
*/
public class Rectangle extends Shape {

	public Rectangle() {
		type = "Rectangle";
	}

	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}

}
