/**
 * 
 */
package com.pcm.command;

/**  
* @Package com.pcm.command 
* @Title: CommandPatternDemo.java   
* @Description: TODO  
* @author pcm  
* @date 2018年7月4日 下午5:04:07
* @version V1.0  
*/
public class CommandPatternDemo {
	public static void main(String[] args) {
		Stock abcStock = new Stock();
		BuyStock buyStockOrder = new BuyStock(abcStock);
		SellStock sellStockOrder = new SellStock(abcStock);
		Broker broker = new Broker();
		broker.takeOrder(buyStockOrder);
		broker.takeOrder(sellStockOrder);
		broker.placeOrders();
	}
}
