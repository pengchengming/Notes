package com.pcm.Prototype;

/**  
* @Package com.pcm.Prototype 
* @Title: Shape.java   
* @Description: 创建一个实现了Clonable接口的抽象类  
* @author pcm  
* @date 2018年7月2日 上午9:25:52
* @version V1.0  
*/
public abstract class Shape implements Cloneable {

	private String id;
	protected String type;

	abstract void draw();

	public String getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/** 
	 * Description:   
	 * @return
	 * @throws CloneNotSupportedException 
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}

	
	
}
