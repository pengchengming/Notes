package com.pcm.facade;

/**  
* @Package com.pcm.facade 
* @Title: FacadePatternDemo.java   
* @Description: 使用该外观类画出各种类型的形状  
* @author pcm  
* @date 2018年7月4日 下午2:11:39
* @version V1.0  
*/
public class FacadePatternDemo {
	public static void main(String[] args) {
		ShapeMaker shapeMaker = new ShapeMaker();
		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();
	}
}
