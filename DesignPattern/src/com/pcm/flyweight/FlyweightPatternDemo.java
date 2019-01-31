package com.pcm.flyweight;

/**  
* @Package com.pcm.flyweight 
* @Title: FlyweightPatternDemo.java   
* @Description: 使用该工厂，通过传递颜色信息来获取实体类的对象  
* @author pcm  
* @date 2018年7月4日 下午2:39:08
* @version V1.0  
*/
public class FlyweightPatternDemo {
	private static final String colors[] = { "Red", "Green", "Blue", "White", "Black" };

	private static String getRandomColor() {
		return colors[(int) (Math.random() * colors.length)];
	}

	private static int getRandomX() {
		return (int) (Math.random() * 100);
	}

	private static int getRandomY() {
		return (int) (Math.random() * 100);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
			circle.setX(getRandomX());
			circle.setY(getRandomY());
			circle.setRadius(100);
			circle.draw();
		}
	}
}
