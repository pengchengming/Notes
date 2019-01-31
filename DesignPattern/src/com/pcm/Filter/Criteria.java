package com.pcm.Filter;

import java.util.List;

/**  
* @Package com.pcm.Filter 
* @Title: Criteria.java   
* @Description: 为标准（Criteria）创建一个接口  
* @author pcm  
* @date 2018年7月2日 下午2:52:16
* @version V1.0  
*/
public interface Criteria {
	public List<Person> meetCriteria(List<Person> persons);
}
