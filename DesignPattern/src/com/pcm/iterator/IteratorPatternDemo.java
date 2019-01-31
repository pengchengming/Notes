package com.pcm.iterator;

/**  
* @Package com.pcm.iterator 
* @Title: IteratorPatternDemo.java   
* @Description: TODO  
* @author pcm  
* @date 2018年7月11日 上午9:12:52
* @version V1.0  
*/
public class IteratorPatternDemo {
	public static void main(String[] args) {
		NameRepository nameRepository = new NameRepository();
		for (Iterator iter = nameRepository.getIterator(); iter.hasNext();) {
			String name = (String) iter.next();
			System.out.println("Name:" + name);
		}
	}
}
