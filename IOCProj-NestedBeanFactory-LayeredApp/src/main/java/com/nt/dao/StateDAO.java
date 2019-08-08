package com.nt.dao;

import java.util.List;

import com.nt.bo.StateBO;

public interface StateDAO {
	
	public List<StateBO> getStateInfoByName(String cond) throws Exception;
}