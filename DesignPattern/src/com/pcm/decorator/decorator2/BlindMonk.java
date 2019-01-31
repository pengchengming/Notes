/**
 * 
 */
package com.pcm.decorator.decorator2;

/**  
* @Package com.pcm.decorator.decorator2 
* @Title: BlindMonk.java   
* @Description: ConcreteComponent 具体英雄盲僧  
* @author pcm  
* @date 2018年7月2日 下午4:46:05
* @version V1.0  
*/
public class BlindMonk implements Hero {

	private String name;

	public BlindMonk(String name){
		this.name=name;
	}

	@Override
	public void learnSkills() {
		System.out.println(name+"学习了以上技能");
	}

}
