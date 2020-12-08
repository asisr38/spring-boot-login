package com.web.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.controller.vo.RoleVO;
import com.web.dao.RolesDaoRepository;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RolesDaoRepository rolesDaoRepository;
	
	@Override
	public List<RoleVO> findAll(){
		return rolesDaoRepository.findAll().stream().map(entity->{
			RoleVO roleVO=new RoleVO();
			BeanUtils.copyProperties(entity, roleVO);
			return roleVO;
		}).collect(Collectors.toList());
	}

}
