package com.pcm.Bridge;

/**  
* @Package com.pcm.Bridge 
* @Title: BridgePatternDemo.java   
* @Description: 使用 Shape 和 DrawAPI 类画出不同颜色的圆。  
* @author pcm  
* @date 2018年7月2日 下午2:31:29
* @version V1.0  
*/
public class BridgePatternDemo {
	public static void main(String[] args) {
		Shape redCircle = new Circle(100, 100, 10, new RedCircle());
		Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

		redCircle.draw();
		greenCircle.draw();

	}
}
