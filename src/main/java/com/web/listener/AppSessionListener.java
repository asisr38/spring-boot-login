package com.web.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.web.service.LoginService;


public class AppSessionListener implements HttpSessionListener {
	
		private LoginService loginService;
		
		public AppSessionListener(LoginService loginService){
			this.loginService=loginService;
		}

		@Override
	    public void sessionCreated(HttpSessionEvent se) {
			System.out.println("loginService = "+loginService);
			se.getSession().setMaxInactiveInterval(60);
	    }

		/**
		 * This will be called always when session expired
		 * 1. timeout
		 * 2.  logout   
		 */
	    @Override
	    public void sessionDestroyed(HttpSessionEvent se) {
	    	HttpSession session=se.getSession();
	    	Integer shid=(Integer)session.getAttribute("shid");
			loginService.updateLogoutTime(shid);
	    }
	
}

