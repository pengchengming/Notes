package com.pcm.facade;

/**  
* @Package com.pcm.facade 
* @Title: ShapeMaker.java   
* @Description: 创建一个外观类ShapeMaker  
* @author pcm  
* @date 2018年7月4日 下午2:06:38
* @version V1.0  
*/
public class ShapeMaker {
	private Shape circle;
	private Shape rectangle;
	private Shape square;

	public ShapeMaker() {
		circle = new Circle();
		rectangle = new Rectangle();
		square = new Square();
	}

	public void drawCircle() {
		circle.draw();
	}

	public void drawRectangle() {
		rectangle.draw();
	}

	public void drawSquare() {
		square.draw();
	}

}
