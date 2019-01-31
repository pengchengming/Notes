/**
 * 
 */
package com.pcm.factory;

/**  
* @Package com.pcm.factory 
* @Title: FactoryPatterDemo.java   
* @Description: 执行程序，输出结果  
* @author pcm  
* @date 2018年6月28日 下午3:34:32
* @version V1.0  
*/

public class FactoryPatterDemo {
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		// 获取 Circle 的对象，并调用它的 draw 方法
		Shape shape1 = shapeFactory.getShape("CIRCLE");

		// 调用 Circle 的 draw 方法
		shape1.draw();

		// 获取 Rectangle 的对象，并调用它的 draw 方法
		Shape shape2 = shapeFactory.getShape("RECTANGLE");

		// 调用 Rectangle 的 draw 方法
		shape2.draw();

		// 获取 Square 的对象，并调用它的 draw 方法
		Shape shape3 = shapeFactory.getShape("SQUARE");

		// 调用 Square 的 draw 方法
		shape3.draw();
	}

}
