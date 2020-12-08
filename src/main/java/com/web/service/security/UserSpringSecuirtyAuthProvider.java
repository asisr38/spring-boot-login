package com.web.service.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.SignupDaoRepository;
import com.web.dao.entity.RoleEntity;
import com.web.dao.entity.SignupEntity;

//Action =auth , method =POST
//form parameter ->>. username , password
@Service
public class UserSpringSecuirtyAuthProvider implements UserDetailsService{
	
	@Autowired
	private SignupDaoRepository signupDaoRepository;

	//
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<SignupEntity> optional=signupDaoRepository.findByUsername(username);
		User user=null;
		if(optional.isPresent()){
			SignupEntity signupEntity=optional.get();
			//Role coming from database
			List<RoleEntity> roles=signupEntity.getRoles();
			//Here converting roles 
			List<GrantedAuthority> sroles=new ArrayList<GrantedAuthority>();
			for(RoleEntity roleEntity:roles){
				GrantedAuthority grantedAuthority=new SimpleGrantedAuthority(roleEntity.getName());
				sroles.add(grantedAuthority);
			}
			user=new User(username, signupEntity.getPassword(), sroles); //this just logged in customer roles
		}else{
			UsernameNotFoundException ex=new UsernameNotFoundException("Sorry user is not in database");
			throw ex;
		}
		return user;
	}

}
