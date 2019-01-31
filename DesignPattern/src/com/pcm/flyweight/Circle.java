/**
 * 
 */
package com.pcm.flyweight;

/**  
* @Package com.pcm.flyweight 
* @Title: Circle.java   
* @Description: 创建实现接口的实体类  
* @author pcm  
* @date 2018年7月4日 下午2:24:38
* @version V1.0  
*/
public class Circle implements Shape {

	private String color;
	private int x;
	private int y;
	private int radius;

	public Circle(String color) {
		this.color = color;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.println("Circle: Draw() [Color : " + color + ", x : " + x + ", y :" + y + ", radius :" + radius);
	}

}
