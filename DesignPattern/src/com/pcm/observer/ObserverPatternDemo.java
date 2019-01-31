package com.pcm.observer;

/**  
* @Package com.pcm.observer 
* @Title: ObserverPatternDemo.java   
* @Description: 使用Subject和实体观察者对象  
* @author pcm  
* @date 2018年7月11日 下午1:05:29
* @version V1.0  
*/
public class ObserverPatternDemo {
	public static void main(String[] args) {
		Subject subject = new Subject();
		new HexaObserver(subject);
		new OctalObserver(subject);
		new BinaryObserver(subject);
		System.out.println("First state change:15");
		subject.setState(15);
		System.out.println("Second state change:10");
		subject.setState(10);
	}
}
