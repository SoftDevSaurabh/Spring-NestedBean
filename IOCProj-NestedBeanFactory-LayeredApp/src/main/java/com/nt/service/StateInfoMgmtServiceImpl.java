package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.StateBO;
import com.nt.dao.StateDAO;
import com.nt.dto.StateDTO;

public class StateInfoMgmtServiceImpl implements StateInfoMgmtService {

	private StateDAO dao;
	
	public StateInfoMgmtServiceImpl(StateDAO dao,String type) {
		System.out.println("StateInfoMgmtServiceImpl..2-param constructor:::"+type);
		this.dao = dao;
	}

	public List<StateDTO> findStateInfoByName(String[] name) throws Exception {
		
		StringBuffer sb = null;
		List<StateBO> listBO = null;
		List<StateDTO> listDTO = null;
		StateDTO dto = null;
		
		//convert name[] to required SQL Condition
		sb = new StringBuffer("(");
		for(int i=0;i<name.length;++i) {
			if(i == name.length-1)
				sb.append("'"+name[i]+"'");
			else
				sb.append("'"+name[i]+"',");
		}
		sb.append(")");
		//use StateDAO
		listBO = dao.getStateInfoByName(sb.toString());
		//convert listBO to listDTO
		listDTO = new ArrayList();
		for(StateBO bo:listBO) {
			dto = new StateDTO();
			BeanUtils.copyProperties(bo,dto);
			dto.setSr_No(listDTO.size()+1);
			listDTO.add(dto);
		}
		return listDTO;
	}
}