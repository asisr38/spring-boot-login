package com.web.controller.vo;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class SignupHistoryVO {
	private int shid;
	private Timestamp intime;
	private Timestamp outtime;
	private String location;
	private String username;

}
