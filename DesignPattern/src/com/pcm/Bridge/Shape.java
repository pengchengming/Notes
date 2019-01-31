package com.pcm.Bridge;

/**  
* @Package com.pcm.Bridge 
* @Title: Shape.java   
* @Description: 使用 DrawAPI 接口创建抽象类 Shape。  
* @author pcm  
* @date 2018年7月2日 下午2:22:38
* @version V1.0  
*/
public abstract class Shape {
	protected DrawAPI drawAPI;

	protected Shape(DrawAPI drawAPI) {
		this.drawAPI = drawAPI;
	}

	public abstract void draw();
}
