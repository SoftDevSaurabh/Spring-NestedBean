package com.nt.controller;

import java.util.List;

import com.nt.dto.StateDTO;
import com.nt.service.StateInfoMgmtService;

public class MainController {

	private StateInfoMgmtService service;

	public MainController(StateInfoMgmtService service) {
		
		this.service = service;
	}
	
	public List<StateDTO> fetchStateInfoByName(String[] name)throws Exception{
		
		List<StateDTO> listDTO = null;
		//Use Service class
		listDTO = service.findStateInfoByName(name);
		return listDTO;
	}
}