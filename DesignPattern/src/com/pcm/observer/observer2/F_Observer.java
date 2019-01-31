package com.pcm.observer.observer2;

/**  
* @Package com.pcm.observer.observer2 
* @Title: F_Observer.java   
* @Description: 第一个观察者  
* @author pcm  
* @date 2018年7月11日 下午2:03:57
* @version V1.0  
*/
public class F_Observer extends Observer {
	public void update(String msg) {
		System.out.println(F_Observer.class.getName() + " : " + msg);
	}
}
