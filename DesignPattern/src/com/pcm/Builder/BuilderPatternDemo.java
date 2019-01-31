package com.pcm.Builder;

/**  
* @Package com.pcm.Builder 
* @Title: BuilderPatternDemo.java   
* @Description: 使用MealBuilder来演示建造者模式(Builder Pattern)  
* @author pcm  
* @date 2018年6月29日 上午9:55:54
* @version V1.0  
*/
public class BuilderPatternDemo {

	public static void main(String[] args) {
		MealBuilder mealBuilder =new MealBuilder();
		
		Meal vegMeal =mealBuilder.prepareVegMeal();
		System.out.println("Veg Meal");
		vegMeal.showItems();
		System.out.println("Total Cost"+vegMeal.getCoast());
		
	    Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
	    System.out.println("\n\nNon-veg Meal");
	    nonVegMeal.showItems();
	    System.out.println("Total Cost:"+nonVegMeal.getCoast());

	    StringBuilder s=new StringBuilder();
	    
	}

}
