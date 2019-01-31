package com.pcm.template;

/**  
* @Package com.pcm.template 
* @Title: TemplatePatternDemo.java   
* @Description: 使用Game的模板方法play()来演示游戏的定义方式  
* @author pcm  
* @date 2018年7月16日 上午10:44:39
* @version V1.0  
*/
public class TemplatePatternDemo {
	public static void main(String[] args) {
		Game game = new Cricket();
		game.play();
		System.out.println();
		game = new Football();
		game.play();
	}
}
