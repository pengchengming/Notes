package com.pcm.iterator;

/**  
* @Package com.pcm.iterator 
* @Title: NameRepository.java   
* @Description: 创建实现了Container接口的实体类，该类有实现了Iterator接口的内部类NameIterator  
* @author pcm  
* @date 2018年7月10日 下午8:54:14
* @version V1.0  
*/
public class NameRepository implements Container {
	public String names[] = { "Robert", "John", "Julie", "Lora" };

	@Override
	public Iterator getIterator() {
		return new NameIterator();
	}

	private class NameIterator implements Iterator {
		int index;

		@Override
		public boolean hasNext() {
			if (index < names.length) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			if (this.hasNext()) {
				return names[index++];
			}
			return null;
		}

	}
}
