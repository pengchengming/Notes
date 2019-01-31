package com.pcm.chainofresponsibility;

/**  
* @Package com.pcm.chainofresponsibility 
* @Title: FileLogger.java   
* @Description: 创建了扩展了AbstractLogger纪录类的实体类FileLogger  
* @author pcm  
* @date 2018年7月4日 下午3:57:07
* @version V1.0  
*/
public class FileLogger extends AbstractLogger {

	public FileLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("File::Logger:" + message);
	}

}
