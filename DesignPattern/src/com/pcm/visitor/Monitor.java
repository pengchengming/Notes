package com.pcm.visitor;

/**  
* @Package com.pcm.visitor 
* @Title: Monitor.java   
* @Description: 创建了实现ComputerPart的实体类Monitor  
* @author pcm  
* @date 2018年7月16日 上午11:20:43
* @version V1.0  
*/
public class Monitor implements ComputerPart{

	@Override
	public void accept(ComputerPartVisitor computerPartVistor) {
		computerPartVistor.visit(this);
	}

}
