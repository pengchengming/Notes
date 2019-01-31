package com.pcm.decorator.decorator1;

/**  
* @Package com.pcm.decorator.decorator1 
* @Title: RedShapeDecorator.java   
* @Description: 创建扩展了ShapeDecorator类的实体装饰类  
* @author pcm  
* @date 2018年7月2日 下午5:41:35
* @version V1.0  
*/
public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}

	
	@Override
	public void draw() {
		decoratedShape.draw();
		setRedBorder(decoratedShape);
	}
	
	public void setRedBorder(Shape decoratedShape) {
		System.out.println("Border Color:Red");
	}
}
