package com.pcm.Interpreter;

/**  
* @Package com.pcm.Interpreter 
* @Title: InterprePatternDemo.java   
* @Description: InterpreterPatternDemo 使用 Expression 类来创建规则，并解析它们。  
* @author pcm  
* @date 2018年7月9日 下午8:30:24
* @version V1.0  
*/
public class InterprePatternDemo {
	// 规则：Robert 和 John 是男性
	public static Expression getMaleExpression() {
		Expression robert = new TerminalExpression("Robert");
		Expression john = new TerminalExpression("John");
		return new OrExpression(robert, john);
	}

	// 规则：Julie 是一个已婚的女性
	public static Expression getMarriedWomanExpression() {
		Expression julie = new TerminalExpression("Julie");
		Expression married = new TerminalExpression("Married");
		return new AndExpression(julie, married);
	}

	public static void main(String[] args) {
		Expression isMale = getMaleExpression();
		Expression isMarriedWoman = getMarriedWomanExpression();

		System.out.println("John is male? " + isMale.interpret("John"));
		System.out.println("Julie is a married women? " + isMarriedWoman.interpret("Married Julie"));
	}
}
