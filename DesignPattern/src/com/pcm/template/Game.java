package com.pcm.template;

/**  
* @Package com.pcm.template 
* @Title: Game.java   
* @Description: 创建一个抽象类，它的模板方法被设置为final  
* @author pcm  
* @date 2018年7月16日 上午10:32:51
* @version V1.0  
*/
public abstract class Game {
	abstract void initialize();

	abstract void startPlay();

	abstract void endPlay();

	// 模板
	public final void play() {
		// 初始化游戏
		initialize();
		// 开始游戏
		startPlay();
		// 结束游戏
		endPlay();
	}
}
