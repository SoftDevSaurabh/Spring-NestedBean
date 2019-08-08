package com.nt.service;

import java.util.List;

import com.nt.dto.StateDTO;

public interface StateInfoMgmtService {

	public List<StateDTO> findStateInfoByName(String name[])throws Exception;
}