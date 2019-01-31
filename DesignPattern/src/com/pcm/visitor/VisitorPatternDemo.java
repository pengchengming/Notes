package com.pcm.visitor;

/**  
* @Package com.pcm.visitor 
* @Title: VisitorPatternDemo.java   
* @Description: 使用ComputerPartDisplayVisitor来显示Computer的组成部分  
* @author pcm  
* @date 2018年7月16日 上午11:31:22
* @version V1.0  
*/
public class VisitorPatternDemo {
	public static void main(String[] args) {
		ComputerPart computer = new Computer();
		computer.accept(new ComputerPartDisplayVisitor());
	}
}
