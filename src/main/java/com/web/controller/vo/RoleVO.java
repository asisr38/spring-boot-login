package com.web.controller.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = {"rid"})
public class RoleVO {

	private int rid;
	private String name;
	private String description;
	private boolean selected;
	

}
