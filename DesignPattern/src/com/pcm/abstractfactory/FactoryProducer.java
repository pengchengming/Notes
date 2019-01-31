package com.pcm.abstractfactory;

/**  
* @Package com.pcm.abstractfactory 
* @Title: FactoryProducer.java   
* @Description: 创建一个工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂。  
* @author pcm  
* @date 2018年6月28日 下午4:06:07
* @version V1.0  
*/
public class FactoryProducer {
	public static AbstractFactory getFactory(String choice) {
		if (choice.equalsIgnoreCase("SHAPE")) {
			return new ShapeFactory();
		} else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
		}
		return null;
	}
}
