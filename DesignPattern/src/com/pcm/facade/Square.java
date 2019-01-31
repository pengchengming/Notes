package com.pcm.facade;

/**  
* @Package com.pcm.facade 
* @Title: Square.java   
* @Description: 创建实现接口的实体类Square  
* @author pcm  
* @date 2018年7月4日 下午2:02:47
* @version V1.0  
*/
public class Square implements Shape{

	@Override
	public void draw() {
		System.out.println("Square::draw");
	}

}
