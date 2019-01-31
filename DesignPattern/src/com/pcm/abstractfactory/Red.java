package com.pcm.abstractfactory;


/**  
* @Package com.pcm.abstractfactory 
* @Title: Red.java   
* @Description: Red实现Color的接口  
* @author pcm  
* @date 2018年6月28日 下午3:49:50
* @version V1.0  
*/
public class Red implements Color {

	/** 
	 * Description: 输出红色  
	 */
	@Override
	public void fill() {
		System.out.println("Inside Red::fill() method.");
	}

}
