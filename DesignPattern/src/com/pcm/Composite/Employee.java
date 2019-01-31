package com.pcm.Composite;

import java.util.ArrayList;
import java.util.List;

/**  
* @Package com.pcm.Composite 
* @Title: Employee.java   
* @Description: 创建Employee ,该类带有Employee对象的列表  
* @author pcm  
* @date 2018年7月2日 下午3:45:13
* @version V1.0  
*/
public class Employee {
	private String name;
	private String dept;
	private int salary;
	private List<Employee> subordinates;

	public Employee(String name, String dept, int salary) {
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		subordinates = new ArrayList<Employee>();
	}

	public void add(Employee e) {
		subordinates.add(e);
	}

	public void remove(Employee e) {
		subordinates.remove(e);
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
	}

}
