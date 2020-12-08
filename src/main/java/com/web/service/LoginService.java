package com.web.service;

import com.web.controller.vo.SignupHistoryVO;

public interface LoginService {

	int saveHistory(SignupHistoryVO historyVO);

	void updateLogoutTime(int shid);

}
