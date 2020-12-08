package com.web.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.dao.entity.RoleEntity;
import com.web.dao.entity.SignupEntity;

public interface RolesDaoRepository extends JpaRepository<RoleEntity, Integer> {

	Optional<RoleEntity> findByName(String srole);

}
