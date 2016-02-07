package com.itclass.services;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Exec {
	
	
	public <T> List<T> query(String sql, RowMapper<? extends T> mapper ) {
		
		List<T> result = new ArrayList<>();
		
		ResultSet rs = null;
		T ob = mapper.map(rs, 0);
		
		result.add(ob);
		
		return result;
	}
	
}

interface RowMapper<T> {
	
	T map(ResultSet set, int i);
	
}