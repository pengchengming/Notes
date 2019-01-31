package com.pcm.abstractfactory;

/**  
* @Package com.pcm.factory 
* @Title: Square.java   
* @Description: Square实现了Shape的接口  
* @author pcm  
* @date 2018年6月28日 下午2:36:36
* @version V1.0  
*/
public class Square implements Shape {

	/** 
	 * Description: 执行了Square的draw方法   
	 */
	@Override
	public void draw() {
		 System.out.println("Inside Square::draw() method.");
	}

}
