package com.web.dao.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//POJO -2006
//POJI

@Entity
@Table(name="user_profiles_tbl")
public class SignupEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int lid;
	@Column(length=255)
	private String username;
	
	@Column(length=1000)
	private String password;
	private String name;
	private String email;
	private String gender;
	private String role;
	private String photo;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="signupEntity",fetch=FetchType.EAGER)
	private List<SignupHistoryEntity> signupHistoryList;
	
	@ManyToMany
    @JoinTable(name = "signup_roles_tbl", 
             joinColumns = { @JoinColumn(name = "lid") }, 
             inverseJoinColumns = { @JoinColumn(name = "rid") })
	private List<RoleEntity> roles = new ArrayList<RoleEntity>();

}
