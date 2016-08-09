
package com.netqin.function.cacheDemo;

import org.springframework.stereotype.Repository;

@Repository
public class CacheDemoDao {
	
	public String getName(int id){
		return "NameId:"+id;
	}

}
