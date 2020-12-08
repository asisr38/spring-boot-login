package com.web.service;

import java.util.List;
import java.util.Map;

import com.web.controller.vo.Signup;

public interface SignupService {

	void update(Signup signup);

	void save(Signup signup);

	void delete(String username);

	Signup findByUsername(String username);

	List<Signup> findAll();

	Map<String, Object> authUser(String username, String password);

	void updateRoles(int lid, String sroles);

	void sendOtp(String username);

	void updatePswd(String username, String nPswd);

}
