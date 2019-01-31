package com.pcm.Bridge;

/**  
* @Package com.pcm.Bridge 
* @Title: GreenCircle.java   
* @Description: 创建实现了 DrawAPI 接口的实体桥接实现类GreenCircle  
* @author pcm  
* @date 2018年7月2日 下午2:18:29
* @version V1.0  
*/
public class GreenCircle implements DrawAPI {

	@Override
	public void drawCircle(int radius, int x, int y) {
		System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]");
	}

}
