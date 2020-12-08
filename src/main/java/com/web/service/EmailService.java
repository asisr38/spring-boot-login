package com.web.service;

import com.web.controller.vo.EmailVO;

public interface EmailService {

	void sendUpdateRoleEmail(EmailVO emailVO);

	void sendUpdatePswdEmail(EmailVO emailVO);

}
