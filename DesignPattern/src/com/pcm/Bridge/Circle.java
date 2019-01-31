package com.pcm.Bridge;

/**  
* @Package com.pcm.Bridge 
* @Title: Circle.java   
* @Description: 创建实现了 Shape 接口的实体类。  
* @author pcm  
* @date 2018年7月2日 下午2:26:05
* @version V1.0  
*/
public class Circle extends Shape {

	private int x, y, radius;

	protected Circle(int x, int y, int radius, DrawAPI drawAPI) {
		super(drawAPI);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	@Override
	public void draw() {
		drawAPI.drawCircle(radius, x, y);
	}

}
