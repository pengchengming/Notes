package com.pcm.observer.observer2;

/**  
* @Package com.pcm.observer.observer2 
* @Title: Main.java   
* @Description: 是观察者订阅被观察者的状态，当被观察者状态改变的时候会通知所有订阅的观察者的过程。  
* @author pcm  
* @date 2018年7月11日 下午2:31:11
* @version V1.0  
*/
public class Main {
	public static void main(String[] args) {
		Subject subject = new Subject();
		F_Observer fObserver = new F_Observer();
		S_Observer sObserver = new S_Observer();
		T_Observer tObserver = new T_Observer();
		subject.addAttach(fObserver);
		subject.addAttach(sObserver);
		subject.addAttach(tObserver);
		subject.setMsg("msg changed");

	}
}
