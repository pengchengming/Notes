package com.pcm.proxy;

/**  
* @Package com.pcm.proxy 
* @Title: ProxyImage.java   
* @Description: 创建实现Image接口的实体类ProxyImage  
* @author pcm  
* @date 2018年7月4日 下午3:03:50
* @version V1.0  
*/
public class ProxyImage implements Image {

	private RealImage realImage;
	private String fileName;

	public ProxyImage(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void display() {
		if (null == realImage) {
			realImage = new RealImage(fileName);
		}
		realImage.display();
	}

}
