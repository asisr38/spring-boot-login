package com.web.controller.vo;

import lombok.Data;

@Data
public class EmailVO {

	private String to;
	private String subject;
	private String currentRoles;
	private String newRoles;
	private String from;
	private String name;
	private String otp;
	
	
}
