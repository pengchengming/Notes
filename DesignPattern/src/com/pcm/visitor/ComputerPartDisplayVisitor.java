package com.pcm.visitor;

/**  
* @Package com.pcm.visitor 
* @Title: ComputerPartDisplayVisitor.java   
* @Description: 创建实现了ComputerPartVisitor类的实体访问者  
* @author pcm  
* @date 2018年7月16日 上午11:28:06
* @version V1.0  
*/
public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

	@Override
	public void visit(Computer computer) {
		System.out.println("Displaying computer.");
	}

	@Override
	public void visit(Keyboard keyboard) {
		System.out.println("Displaying keyboard.");
	}

	@Override
	public void visit(Mouse mouse) {
		System.out.println("Displaying mouse.");
	}

	@Override
	public void visit(Monitor monitor) {
		System.out.println("Displaying monitor.");
	}

}
