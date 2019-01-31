/**
 * 
 */
package com.pcm.Builder;

/**  
* @Package com.pcm.Builder 
* @Title: Coke.java   
* @Description: 创建了扩展ColdDrink的实体类  
* @author pcm  
* @date 2018年6月29日 上午9:37:52
* @version V1.0  
*/
public class Coke extends ColdDrink{

	@Override
	public String name() {
		return "Coke";
	}

	@Override
	public float price() {
		return 10.0f;
	}

}
