/**
 * 
 */
package com.pcm.singleton;

/**  
* @Package com.pcm.Singleton 
* @Title: SingleObject.java   
* @Description: 创建了一个Singleton类  
* @author pcm  
* @date 2018年6月28日 下午4:37:04
* @version V1.0  
*/
public class SingleObject {
	// 创建SingleObject的一个对象
	private static SingleObject instance = new SingleObject();

	// 让构造函数为 private ,这样类就不会被实例化
	private SingleObject() {
	}
	
	//获取唯一可用的对象
	public static SingleObject getInstance(){
		return instance;
	}
	
	public void showMessage(){
		System.out.println("Hello world! Singleton");
	}

}
