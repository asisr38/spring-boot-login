package com.web.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.controller.vo.Signup;
import com.web.dao.entity.SignupEntity;

public interface SignupDaoRepository extends JpaRepository<SignupEntity, Integer> {

	public Optional<SignupEntity> findByUsername(String username);

	public Optional<SignupEntity> findByUsernameAndPassword(String username, String password);

	public long deleteByUsername(String username);

	public Optional<Signup> findByEmail(String email);

}
