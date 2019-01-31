package com.pcm.Builder;

/**  
* @Package com.pcm.Builder 
* @Title: Bottle.java   
* @Description:创建实现Packing接口的实体类  
* @author pcm  
* @date 2018年6月29日 上午9:27:46
* @version V1.0  
*/
public class Bottle implements Packing {

	/** 
	 * Description: 打包方式为瓶装
	 * @return 
	 */
	@Override
	public String pack() {
		return "Bottle";
	}

}
