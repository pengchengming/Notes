package com.pcm.proxy;

/**  
* @Package com.pcm.proxy 
* @Title: ProxyPatternDemo.java   
* @Description: 当被请求时，使用ProxyImage来获取RealImage类的对象  
* @author pcm  
* @date 2018年7月4日 下午3:08:15
* @version V1.0  
*/
public class ProxyPatternDemo {
	public static void main(String[] args) {
		Image image = new ProxyImage("test。jpg");

		// 图像将从磁盘中加载
		image.display();
		System.out.println("");
		// 图像将不从磁盘中加载
		image.display();
	}
}
