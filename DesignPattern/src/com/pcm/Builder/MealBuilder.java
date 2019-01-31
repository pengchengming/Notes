package com.pcm.Builder;

/**  
* @Package com.pcm.Builder 
* @Title: MealBuilder.java   
* @Description: 创建一个 MealBuilder 类，实际的 builder 类负责创建 Meal 对象。  
* @author pcm  
* @date 2018年6月29日 上午9:50:38
* @version V1.0  
*/
public class MealBuilder {
	public Meal prepareVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;
	}

	public Meal prepareNonVegMeal() {
         Meal meal =new Meal();
         meal.addItem(new ChickenBurger());
         meal.addItem(new Pepsi());
         return meal;
	}
}
