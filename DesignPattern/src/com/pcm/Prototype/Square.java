package com.pcm.Prototype;

/**  
* @Package com.pcm.Prototype 
* @Title: Square.java   
* @Description: 创建扩展了 Shape抽象类的实体类Square
* @author pcm  
* @date 2018年7月2日 上午10:01:45
* @version V1.0  
*/
public class Square extends Shape {

	public Square() {
		type = "Square";
	}

	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}

}
