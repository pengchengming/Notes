package com.pcm.Filter;

/**  
* @Package com.pcm.Filter 
* @Title: Person.java   
* @Description: 创建一个Person类，在该类上应用标准。  
* @author pcm  
* @date 2018年7月2日 下午2:48:02
* @version V1.0  
*/
public class Person {
	private String name;
	private String gender;
	private String maritalStatus;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Person(String name, String gender, String maritalStatus) {
		super();
		this.name = name;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
	}
}
