package com.web.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="roles_tbl")
@Data
public class RoleEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rid;
	private String name;
	private String description;
	
	

}
