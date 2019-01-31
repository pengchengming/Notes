package com.pcm.Filter;

import java.util.List;
/**  
* @Package com.pcm.Filter 
* @Title: OrCriteria.java   
* @Description: TODO  
* @author pcm  
* @date 2018年7月2日 下午3:05:37
* @version V1.0  
*/
public class OrCriteria implements Criteria {

	private Criteria criteria;
	private Criteria otherCriteria;

	public OrCriteria(Criteria criteria, Criteria otherCriteria) {
		super();
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}

	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> firstCriteriaItems  = criteria.meetCriteria(persons);
		List<Person> otherCriteriaItems  = otherCriteria.meetCriteria(persons);
		for (Person person : otherCriteriaItems) {
			if(!firstCriteriaItems.contains(person)){
				firstCriteriaItems.add(person);
			}
		}
		return firstCriteriaItems;
	}

}
