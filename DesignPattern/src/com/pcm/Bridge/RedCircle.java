package com.pcm.Bridge;

/**  
* @Package com.pcm.Bridge 
* @Title: RedCircle.java   
* @Description: 创建实现了 DrawAPI 接口的实体桥接实现类RedCircle  
* @author pcm  
* @date 2018年7月2日 下午2:15:37
* @version V1.0  
*/
public class RedCircle implements DrawAPI {

	@Override
	public void drawCircle(int radius, int x, int y) {
		System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]");
	}

}
