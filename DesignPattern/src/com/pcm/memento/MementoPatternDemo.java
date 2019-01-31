package com.pcm.memento;

/**  
* @Package com.pcm.memeto 
* @Title: MementoPatternDemo.java   
* @Description: 使用CareTaker和Originator对象  
* @author pcm  
* @date 2018年7月11日 上午11:10:38
* @version V1.0  
*/
public class MementoPatternDemo {
	public static void main(String[] args) {
		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();
		originator.setState("State #1");
		originator.setState("State #2");
		careTaker.add(originator.saveStateToMemento());
		originator.setState("State #3");
		careTaker.add(originator.saveStateToMemento());
		originator.setState("State #4");

		System.out.println("Current State" + originator.getState());
		originator.getStateFromMemenTo(careTaker.get(0));
		System.out.println("First saved State" + originator.getState());
		originator.getStateFromMemenTo(careTaker.get(1));
		System.out.println("Second saved State" + originator.getState());
	}
}
