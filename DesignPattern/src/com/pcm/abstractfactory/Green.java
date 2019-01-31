package com.pcm.abstractfactory;

/**  
* @Package com.pcm.abstractfactory 
* @Title: Green.java   
* @Description: Green实现了Color的接口  
* @author pcm  
* @date 2018年6月28日 下午3:52:04
* @version V1.0  
*/
public class Green implements Color {

	/** 
	 * Description:  打印绿色填充  
	 */
	@Override
	public void fill() {
		 System.out.println("Inside Green::fill() method.");
	}

}
