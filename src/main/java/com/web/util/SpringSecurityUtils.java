package com.web.util;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class SpringSecurityUtils {
	
	  /**
    *
    * @param role
    * @return
    */
   public static boolean hasRole(String role) {
       Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().
               getAuthentication().getAuthorities();
       boolean hasRole = false;
       for (GrantedAuthority authority : authorities) {
           hasRole = authority.getAuthority().equalsIgnoreCase(role);
           if (hasRole) {
               break;
           }
       }
       return hasRole;
   }


}
