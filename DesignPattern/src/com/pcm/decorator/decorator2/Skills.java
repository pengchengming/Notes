package com.pcm.decorator.decorator2;

/**  
* @Package com.pcm.decorator.decorator2 
* @Title: Skills.java   
* @Description: Decorator 技能栏  
* @author pcm  
* @date 2018年7月2日 下午4:57:58
* @version V1.0  
*/
public class Skills implements Hero {

	// 持有一个英雄对象接口
	private Hero hero;

	public Skills(Hero hero) {
		this.hero = hero;
	}

	@Override
	public void learnSkills() {
		if (hero != null) {
           hero.learnSkills();
		}
	}

}
