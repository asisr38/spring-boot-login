package com.web.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.controller.vo.SignupHistoryVO;
import com.web.dao.SignupDaoRepository;
import com.web.dao.SignupHistoryDaoRepository;
import com.web.dao.entity.SignupEntity;
import com.web.dao.entity.SignupHistoryEntity;
import com.web.util.DateUtils;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private SignupHistoryDaoRepository signupHistoryDaoRepository;
	
	@Autowired
	private SignupDaoRepository signupDaoRepository;
	
	
	@Override
	public void updateLogoutTime(int shid) {
		SignupHistoryEntity signupHistoryEntity=signupHistoryDaoRepository.findById(shid).get();
		signupHistoryEntity.setOuttime(DateUtils.getCurrentTime());
	}
	
	
	@Override
	@Transactional
	public int saveHistory(SignupHistoryVO historyVO) {
		SignupHistoryEntity signupHistoryEntity=new SignupHistoryEntity();
		BeanUtils.copyProperties(historyVO, signupHistoryEntity);
		
		//Assuming signup means user is already there
		SignupEntity signupEntity=signupDaoRepository.findByUsername(historyVO.getUsername()).get();
		signupHistoryEntity.setSignupEntity(signupEntity);
		
		SignupHistoryEntity dentity=signupHistoryDaoRepository.save(signupHistoryEntity);
		return dentity.getShid();
	}

}
