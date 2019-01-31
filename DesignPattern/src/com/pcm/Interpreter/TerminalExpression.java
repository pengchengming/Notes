package com.pcm.Interpreter;

/**  
* @Package com.pcm.Interpreter 
* @Title: TerminalExpression.java   
* @Description: 创建实现了上述接口的实体类TerminalExpression。  
* @author pcm  
* @date 2018年7月9日 下午8:08:55
* @version V1.0  
*/
public class TerminalExpression implements Expression {
	private String data;

	public TerminalExpression(String data) {
		this.data = data;
	}

	@Override
	public boolean interpret(String context) {
		if (context.contains(data)) {
			return true;
		}
		return false;
	}

}
