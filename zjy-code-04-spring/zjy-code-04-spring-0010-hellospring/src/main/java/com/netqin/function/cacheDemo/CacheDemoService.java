
package com.netqin.function.cacheDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheDemoService {

	@Autowired
	private CacheDemoDao dao;
	
	@Cacheable(value = "id")
	public String getName(int id){
		System.out.println("Processing testCaching");
		return dao.getName(id);
	}


}
