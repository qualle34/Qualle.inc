package com.inc.qualle.security;

import com.inc.qualle.security.enums.Authorities;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SessionUtil {

    public static String getUserLogin(Authentication authentication) {
        Object principal = authentication != null ? authentication.getPrincipal() : null;
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        if (principal != null) {
            return principal.toString();
        }
        return null;
    }

    public static boolean isAuthenticated(Authentication authentication) {
        return authentication != null && authentication.isAuthenticated();
    }

    public static String getAuthority(Authentication authentication) {

        if (authentication != null && authentication.isAuthenticated()) {
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
                return Authorities.ADMIN.name();
            }
            return Authorities.USER.name();
        }
        return Authorities.ANONYMOUS.name();
    }
}