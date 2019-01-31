package com.pcm.decorator.decorator2;

/**  
* @Package com.pcm.decorator.decorator2 
* @Title: Skill_E.java   
* @Description: //ConreteDecorator 技能：E  
* @author pcm  
* @date 2018年7月2日 下午5:03:29
* @version V1.0  
*/
public class Skill_E extends Skills {

	private String skillName;

	public Skill_E(Hero hero, String skillName) {
		super(hero);
		this.skillName = skillName;
	}

	@Override
	public void learnSkills() {
		System.out.println("学习了技能E:" + skillName);
		super.learnSkills();
	}

}
