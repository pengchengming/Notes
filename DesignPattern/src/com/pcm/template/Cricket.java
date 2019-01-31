package com.pcm.template;

/**  
* @Package com.pcm.template 
* @Title: Cricket.java   
* @Description: 创建扩展了上述类的实体类  Cricket
* @author pcm  
* @date 2018年7月16日 上午10:37:44
* @version V1.0  
*/
public class Cricket extends Game {

	@Override
	void initialize() {
		System.out.println("Cricket Game Initialized! Start playing。");
	}

	@Override
	void startPlay() {
		System.out.println("Cricket Game Started.Enjoy the game!");
	}

	@Override
	void endPlay() {
		System.out.println("Cricket Game Finished!");
	}

}
