package com.pcm.proxy;

/**  
* @Package com.pcm.proxy 
* @Title: RealImage.java   
* @Description: 创建实现Image接口的实体类RealImage  
* @author pcm  
* @date 2018年7月4日 下午2:59:45
* @version V1.0  
*/
public class RealImage implements Image {

	private String fileName;

	public RealImage(String fileName) {
		this.fileName = fileName;
		loadFromDisk(fileName);
	}

	private void loadFromDisk(String fileName) {
		System.out.println("Loading：" + fileName);
	}

	@Override
	public void display() {
		System.out.println("Displaying " + fileName);
	}

}
