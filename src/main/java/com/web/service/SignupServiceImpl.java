package com.web.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.controller.vo.EmailVO;
import com.web.controller.vo.RoleVO;
import com.web.controller.vo.Signup;
import com.web.dao.ProfileDaoRepository;
import com.web.dao.ProfileDaoRepository.ProfileDTO;
import com.web.dao.RolesDaoRepository;
import com.web.dao.SignupDaoRepository;
import com.web.dao.SignupHistoryDaoRepository;
import com.web.dao.entity.ProfileEntity;
import com.web.dao.entity.RoleEntity;
import com.web.dao.entity.SignupEntity;

@Service
@Transactional
public class SignupServiceImpl implements SignupService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	// private SignupDao signupDao;
	@Autowired
	private SignupDaoRepository signupDaoRepository;

	@Autowired
	private ProfileDaoRepository profileDaoRepository;

	@Autowired
	private SignupHistoryDaoRepository signupHistoryDaoRepository;

	@Autowired
	private RolesDaoRepository rolesDaoRepository;

	@Autowired
	private EmailService emailService;

	@PostConstruct
	public void call() {
		List<ProfileDTO> profileDTOs = profileDaoRepository.fetchProfileSignupDataLeftJoin("YADAV");

		profileDTOs.forEach(ss -> {
			System.out.println(ss.getEmail());
			System.out.println(ss.getName());
		});
	}

	// 1,2,3
	@Override
	public void updateRoles(int lid, String sroles) {
		SignupEntity entity = signupDaoRepository.findById(lid).get();

		List<RoleEntity> croles = new ArrayList<>();
		// 1,3,4
		String[] roles = sroles.split(","); // {"1","3","4"}
		if (roles.length > 0) {
			for (String role : roles) {
				RoleEntity roleEntity = rolesDaoRepository.findById(Integer.parseInt(role)).get();
				croles.add(roleEntity);
			}
		}
		// We are making new list of new selected roles
		entity.setRoles(croles);
		EmailVO emailVO = new EmailVO();
		emailVO.setTo(entity.getEmail());
		emailVO.setName(entity.getName());
		emailVO.setCurrentRoles(entity.getRoles().stream().map(RoleEntity::getName).collect(Collectors.joining(",")));
		emailVO.setNewRoles(croles.stream().map(RoleEntity::getName).collect(Collectors.joining(",")));
		emailVO.setFrom("oaoauauauau@gmail.com");
		emailVO.setSubject("Regarding your role updation!");
		emailService.sendUpdateRoleEmail(emailVO);
		// signupDaoRepository.save(entity);
	}

	@Override
	public void update(Signup signup) {
		SignupEntity entity = new SignupEntity();
		BeanUtils.copyProperties(signup, entity);
		signupDaoRepository.save(entity);
	}

	@Override
	public void save(Signup signup) {
		String srole = signup.getRole();
		SignupEntity entity = new SignupEntity();
		BeanUtils.copyProperties(signup, entity);

		List<RoleEntity> roles = new ArrayList<>();
		RoleEntity roleEntity = rolesDaoRepository.findByName(srole).get();
		roles.add(roleEntity);
		entity.setRoles(roles);

		// Encypting password
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		ProfileEntity profileEntity = new ProfileEntity();
		profileEntity.setAddress("Coming soon!");
		profileEntity.setDoe(new Timestamp(new Date().getTime()));
		profileEntity.setEducation("MS");
		profileEntity.setSsn("133244");
		profileEntity.setSignup(entity);
		// Saving child now
		profileDaoRepository.save(profileEntity);

	}

	@Override
	@Transactional
	public void delete(String username) {
		SignupEntity entity = signupDaoRepository.findByUsername(username).get();
		signupDaoRepository.delete(entity);
	}

	// @PostFilter("hasAuthority('Administrator') or hasAuthority('Compliance
	// Manager') AND filterObject.oid == authentication.name")b
	@Override
	public Signup findByUsername(String username) {
		SignupEntity entity = signupDaoRepository.findByUsername(username).get();
		Signup signup = new Signup();
		BeanUtils.copyProperties(entity, signup);

		List<RoleVO> roleVOs = new ArrayList<>();
		List<RoleEntity> crole = entity.getRoles();
		for (RoleEntity re : crole) {
			RoleVO roleVO = new RoleVO();
			BeanUtils.copyProperties(re, roleVO);
			roleVOs.add(roleVO);
		}
		signup.setRoleVOs(roleVOs);
		return signup;
	}

	@Override
	public List<Signup> findAll() {
		List<SignupEntity> signups = signupDaoRepository.findAll();
		List<Signup> signups2 = new ArrayList<Signup>();
		// Converting List<SignupEntity> into List<Signup>
		for (SignupEntity entity : signups) {
			Signup signup = new Signup();
			BeanUtils.copyProperties(entity, signup);
			signups2.add(signup);
		}
		return signups2;
	}

	@Override
	public Map<String, Object> authUser(String username, String password) {
		Optional<SignupEntity> optional = signupDaoRepository.findByUsernameAndPassword(username, password);
		Map<String, Object> maps = new HashMap<>();
		if (optional.isPresent()) {
			SignupEntity signupEntity = optional.get();
			maps.put("username", signupEntity.getUsername());
			maps.put("email", signupEntity.getEmail());
			maps.put("password", signupEntity.getPassword());
			maps.put("gender", signupEntity.getGender());
			maps.put("name", signupEntity.getName());
			maps.put("photo", signupEntity.getPhoto());
		}

		return maps;
	}

	@Override
	public void sendOtp(String username) {
		SignupEntity entity = signupDaoRepository.findByUsername(username).get();
		System.out.println(entity.toString());
		// We are making new list of new selected roles
		// Code to send email
		EmailVO emailVo = new EmailVO();
		emailVo.setTo(entity.getEmail());
		emailVo.setName(entity.getUsername());
		emailVo.setSubject("Regarding PSWD change");
		emailVo.setFrom("asisr38@gmail.com");
		emailService.sendUpdatePswdEmail(emailVo);
	}

	@Override
	public void updatePswd(String username, String nPswd) {
		SignupEntity entity = signupDaoRepository.findByUsername(username).get();
		entity.setPassword(nPswd);

	}

}
