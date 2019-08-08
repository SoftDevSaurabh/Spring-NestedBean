package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class StateDTO implements Serializable {

	private int sr_No;
	private int state_ID;
	private String state_Name;
	private String state_Capital;
	private long state_Population;
	private String state_CM;
}