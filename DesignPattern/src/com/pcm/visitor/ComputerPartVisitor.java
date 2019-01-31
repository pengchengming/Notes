package com.pcm.visitor;

/**  
* @Package com.pcm.visitor 
* @Title: ComputerPartVisitor.java   
* @Description: 定义一个表示访问者的接口ComputerPartVisitor  
* @author pcm  
* @date 2018年7月16日 上午11:15:36
* @version V1.0  
*/
public interface ComputerPartVisitor {
	public void visit(Computer computer);

	public void visit(Keyboard keyboard);

	public void visit(Mouse mouse);

	public void visit(Monitor monitor);

}
