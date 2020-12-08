package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.controller.vo.Signup;
import com.web.service.LoginService;
import com.web.service.RoleService;
import com.web.service.SignupService;

@RestController
@RequestMapping("/api")
public class ProfileServiceAPI {
	
	@Autowired
	private SignupService signupService;
	
	@Autowired
	private LoginService loginService;
	

	@Autowired
	private RoleService roleService;
	

	@GetMapping(value="/signups",params={"username"})
	public Signup getSignupData(@RequestParam String username) {
		Signup signup = signupService.findByUsername(username);
		return signup;
	}

	
	//This is called API
	@GetMapping("/signups")
	public List<Signup> showAllData() {
		List<Signup> signups=signupService.findAll();
		return signups; /// WEB-INF/pages/signups.jsp
	}

}
