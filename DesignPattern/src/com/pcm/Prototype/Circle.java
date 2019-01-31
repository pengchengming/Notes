package com.pcm.Prototype;

/**  
* @Package com.pcm.Prototype 
* @Title: Circle.java   
* @Description: 创建扩展了 Shape抽象类的实体类Circle
* @author pcm  
* @date 2018年7月2日 上午10:01:45
* @version V1.0  
*/
public class Circle extends Shape {

	public Circle() {
		type = "Circle";
	}

	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}

}
