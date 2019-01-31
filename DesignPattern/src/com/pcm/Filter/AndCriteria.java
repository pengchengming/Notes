/**
 * 
 */
package com.pcm.Filter;

import java.util.List;

/**  
* @Package com.pcm.Filter 
* @Title: AndCriteria.java   
* @Description: TODO  
* @author pcm  
* @date 2018年7月2日 下午3:05:37
* @version V1.0  
*/
public class AndCriteria implements Criteria {

	private Criteria criteria;
	private Criteria otherCriteria;

	public AndCriteria(Criteria criteria, Criteria otherCriteria) {
		super();
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}

	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> firstCriteriaPersons  = criteria.meetCriteria(persons);
		return otherCriteria.meetCriteria(firstCriteriaPersons);
	}

}
