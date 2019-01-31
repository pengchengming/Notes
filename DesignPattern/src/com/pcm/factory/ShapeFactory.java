/**
 * 
 */
package com.pcm.factory;

/**  
* @Package com.pcm.factory 
* @Title: ShapeFactory.java   
* @Description: TODO  
* @author pcm  
* @date 2018年6月28日 下午2:40:06
* @version V1.0  
*/
public class ShapeFactory {

	public Shape getShape(String shapeType) {
		if (null == shapeType || shapeType.equals("")) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
		} else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
		}else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}
		return null;
	}

}
