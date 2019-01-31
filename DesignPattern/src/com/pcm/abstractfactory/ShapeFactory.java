package com.pcm.abstractfactory;

/**  
* @Package com.pcm.abstractfactory 
* @Title: ShapeFactory.java   
* @Description: 创建扩展了AbstractFactory的工厂类，基于给定的信息生成实体类的对象
* @author pcm  
* @date 2018年6月28日 下午3:57:16
* @version V1.0  
*/
public class ShapeFactory extends AbstractFactory {

	@Override
	public Color getColor(String color) {
		return null;
	}

	@Override
	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		} else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}
		return null;
	}

}
