package com.pcm.chainofresponsibility;

/**  
* @Package com.pcm.chainofresponsibility 
* @Title: ErrorLogger.java   
* @Description: 创建了扩展了AbstractLogger纪录类的实体类ErrorLogger  
* @author pcm  
* @date 2018年7月4日 下午3:57:07
* @version V1.0  
*/
public class ErrorLogger extends AbstractLogger {

	public ErrorLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("Error Console::Logger:" + message);
	}

}
