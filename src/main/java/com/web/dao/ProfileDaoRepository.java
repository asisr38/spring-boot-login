package com.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web.dao.entity.ProfileEntity;

public interface ProfileDaoRepository extends JpaRepository<ProfileEntity, Integer>{

/*	@Query("SELECT new com.web.controller.vo.ProfileDTO(p.address, p.education, p.ssn,s.name,s.email) "
			+ "FROM ProfileEntity p LEFT JOIN p.signup s")
	List<ProfileDTO> fetchProfileSignupDataLeftJoin();*/
	
	
  @Query(value="select   p.address as address,p.education as education,p.ssn as ssn,u.name as name,u.email as email  from  profiles_tbl p  left outer join  user_profiles_tbl u  on p.fsid=u.lid where u.name=?1",nativeQuery=true)
  List<ProfileDTO> fetchProfileSignupDataLeftJoin(String name);
	
  public static interface ProfileDTO {

	   String getAddress();
		 String getEducation();
		 String getSsn();
		 String getName();
		 String getEmail();

	  }
	
}
