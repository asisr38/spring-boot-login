package com.web.dao.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.web.dao.entity.SignupEntity;

@Entity
@Table(name = "profiles_tbl")
public class ProfileEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String address;
	private String education;
	private String ssn;
	private String role;
	private Timestamp doe;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fsid", unique = true, nullable = false)
	private SignupEntity signup;

	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public SignupEntity getSignup() {
		return signup;
	}

	public void setSignup(SignupEntity signup) {
		this.signup = signup;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}

	@Override
	public String toString() {
		return "ProfileEntity [pid=" + pid + ", address=" + address + ", education=" + education + ", ssn=" + ssn
				+ ", doe=" + doe + "]";
	}

}
