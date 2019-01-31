package com.pcm.decorator.decorator1;

/**  
* @Package com.pcm.decorator 
* @Title: ShapeDecorator.java   
* @Description: 创建实现了Shape接口的抽象装饰类  
* @author pcm  
* @date 2018年7月2日 下午5:36:45
* @version V1.0  
*/
public class ShapeDecorator implements Shape {

	public Shape decoratedShape;

	public ShapeDecorator(Shape decoratedShape) {
		super();
		this.decoratedShape = decoratedShape;
	}

	@Override
	public void draw() {
		decoratedShape.draw();
	}

}
