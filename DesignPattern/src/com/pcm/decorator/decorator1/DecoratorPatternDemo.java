package com.pcm.decorator.decorator1;

/**  
* @Package com.pcm.decorator.decorator1 
* @Title: DecoratorPatternDemo.java   
* @Description: 使用RedShapeDecorator  
* @author pcm  
* @date 2018年7月2日 下午5:48:00
* @version V1.0  
*/
public class DecoratorPatternDemo {
	public static void main(String[] args) {
		Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle =new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();
        
        System.out.println("\nCircle of red border");
        redCircle.draw();
        
        System.out.println("\nRectangle of red border");
        redRectangle.draw();
        
	}
}
