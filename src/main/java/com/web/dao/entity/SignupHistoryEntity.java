package com.web.dao.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="signup_history_tbl")
public class SignupHistoryEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int shid;
	private Timestamp intime;
	private Timestamp outtime;
	private String location;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fsid",nullable=false,unique=false)
	private SignupEntity signupEntity;
	
	public int getShid() {
		return shid;
	}
	public void setShid(int shid) {
		this.shid = shid;
	}
	public Timestamp getIntime() {
		return intime;
	}
	public void setIntime(Timestamp intime) {
		this.intime = intime;
	}
	public Timestamp getOuttime() {
		return outtime;
	}
	public void setOuttime(Timestamp outtime) {
		this.outtime = outtime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public SignupEntity getSignupEntity() {
		return signupEntity;
	}
	public void setSignupEntity(SignupEntity signupEntity) {
		this.signupEntity = signupEntity;
	}
	@Override
	public String toString() {
		return "SignupHistoryEntity [shid=" + shid + ", intime=" + intime + ", outtime=" + outtime + ", location="
				+ location + ", signupEntity=" + signupEntity + "]";
	}
	
	

}
