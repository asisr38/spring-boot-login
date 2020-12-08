package com.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.web.dao.entity.SignupHistoryEntity;

public interface SignupHistoryDaoRepository extends JpaRepository<SignupHistoryEntity, Integer>{
	

	@Modifying
	@Query("delete from SignupHistoryEntity t where t.signupEntity.username=?1")
	public void deleteHistory(String username);
	
}
