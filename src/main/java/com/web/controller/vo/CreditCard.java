package com.web.controller.vo;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class CreditCard {
	private int cid;
	private String name;
	private int cvv;
	private String exp;
	private String cardHolder;

}
