package com.web.controller.vo;

import lombok.Data;

@Data
public class ProfileDTO {
	
	private String address;
	private String education;
	private String ssn;
	private String name;
	private String email;
	public ProfileDTO(String address, String education, String ssn, String name, String email) {
		super();
		this.address = address;
		this.education = education;
		this.ssn = ssn;
		this.name = name;
		this.email = email;
	}
	@Override
	public String toString() {
		return "ProfileDTO [address=" + address + ", education=" + education + ", ssn=" + ssn + ", name=" + name
				+ ", email=" + email + "]";
	}
	
	
	

}
