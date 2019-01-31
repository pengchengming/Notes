package com.pcm.command;

/**  
* @Package com.pcm.command 
* @Title: BuyStock.java   
* @Description: 创建了实现了Order接口的实体类  BuyStock
* @author pcm  
* @date 2018年7月4日 下午4:54:42
* @version V1.0  
*/
public class BuyStock implements Order {

	private Stock abcStock;

	public BuyStock(Stock abcStock) {
		this.abcStock = abcStock;
	}

	@Override
	public void execute() {
		abcStock.buy();
	}

}
