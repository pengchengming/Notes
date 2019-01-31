package com.pcm.abstractfactory;

/**  
* @Package com.pcm.abstractfactory 
* @Title: Blue.java   
* @Description: Blue实现了Color的接口  
* @author pcm  
* @date 2018年6月28日 下午3:53:42
* @version V1.0  
*/
public class Blue implements Color {

	/** 
	 * Description:   填充蓝色 
	 */
	@Override
	public void fill() {
		System.out.println("Inside Blue::fill() method.");
	}

}
