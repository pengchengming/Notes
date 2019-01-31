package com.pcm.abstractfactory;

/**  
* @Package com.pcm.abstractfactory 
* @Title: ColorFactory.java   
* @Description: 创建扩展了 AbstractFactory 的工厂类，基于给定的信息生成实体类的对象。  
* @author pcm  
* @date 2018年6月28日 下午4:04:07
* @version V1.0  
*/
public class ColorFactory extends AbstractFactory {

	@Override
	public Color getColor(String color) {
		if (color == null) {
			return null;
		}
		if (color.equalsIgnoreCase("RED")) {
			return new Red();
		} else if (color.equalsIgnoreCase("GREEN")) {
			return new Green();
		} else if (color.equalsIgnoreCase("BLUE")) {
			return new Blue();
		}
		return null;
	}

	@Override
	public Shape getShape(String shape) {
		return null;
	}

}
