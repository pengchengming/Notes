package com.pcm.flyweight;

import java.util.HashMap;

/**  
* @Package com.pcm.flyweight 
* @Title: ShapeFactory.java   
* @Description: 创建一个工厂，生成基于给定信息的实体类的对象  
* @author pcm  
* @date 2018年7月4日 下午2:27:51
* @version V1.0  
*/
public class ShapeFactory {
	private static final HashMap<String, Shape> circleMap = new HashMap<>();

	public static Shape getCircle(String color) {
		Circle circle = (Circle) circleMap.get(color);
		if (null == circle) {
			circle = new Circle(color);
			circleMap.put(color, circle);
			System.out.println("Creating circle of color:" + color);
		}
		return circle;
	}
}
