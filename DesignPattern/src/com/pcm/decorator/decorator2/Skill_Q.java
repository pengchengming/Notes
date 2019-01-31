package com.pcm.decorator.decorator2;

/**  
* @Package com.pcm.decorator.decorator2 
* @Title: Skill_Q.java   
* @Description: //ConreteDecorator 技能：Q  
* @author pcm  
* @date 2018年7月2日 下午5:03:29
* @version V1.0  
*/
public class Skill_Q extends Skills {

	private String skillName;

	public Skill_Q(Hero hero, String skillName) {
		super(hero);
		this.skillName = skillName;
	}

	@Override
	public void learnSkills() {
		System.out.println("学习了技能Q:" + skillName);
		super.learnSkills();
	}

}
