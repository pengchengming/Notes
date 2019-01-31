package com.pcm.visitor;

/**  
* @Package com.pcm.visitor 
* @Title: ComputerPart.java   
* @Description: 定义一个表示元素的接口ComputerPart  
* @author pcm  
* @date 2018年7月16日 上午11:13:05
* @version V1.0  
*/
public interface ComputerPart {
public void accept(ComputerPartVisitor computerPartVistor);
}
