package com.pcm.visitor;

/**  
* @Package com.pcm.visitor 
* @Title: Keyboard.java   
* @Description: 创建扩展了ComputerPart的实体类  
* @author pcm  
* @date 2018年7月16日 上午11:17:01
* @version V1.0  
*/
public class Keyboard implements ComputerPart {

	@Override
	public void accept(ComputerPartVisitor computerPartVistor) {
		computerPartVistor.visit(this);

	}

}
