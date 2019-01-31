package com.pcm.visitor;

/**  
* @Package com.pcm.visitor 
* @Title: Computer.java   
* @Description: 创建了实现ComputerPart的实体类Computer  
* @author pcm  
* @date 2018年7月16日 上午11:20:28
* @version V1.0  
*/
public class Computer implements ComputerPart {

	ComputerPart[] parts;

	public Computer() {
		parts = new ComputerPart[] { new Mouse(), new Keyboard(), new Monitor() };
	}

	@Override
	public void accept(ComputerPartVisitor computerPartVistor) {
		for (int i = 0; i < parts.length; i++) {
			parts[i].accept(computerPartVistor);
		}
		computerPartVistor.visit(this);
	}

}
