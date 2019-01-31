package com.pcm.visitor;

/**  
* @Package com.pcm.visitor 
* @Title: Mouse.java   
* @Description: 创建了实现ComputerPart的实体类Mouse
* @author pcm  
* @date 2018年7月16日 上午11:20:35
* @version V1.0  
*/
public class Mouse implements ComputerPart{

	@Override
	public void accept(ComputerPartVisitor computerPartVistor) {
		computerPartVistor.visit(this);
	}

}
