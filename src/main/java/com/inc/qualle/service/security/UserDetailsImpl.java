package com.inc.qualle.service.security;

import com.inc.qualle.model.entity.User;
import com.inc.qualle.model.entity.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserDetailsImpl implements UserDetails {

    private User user;

    public UserDetailsImpl() {
    }

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();
        if (UserRole.ADMIN.equals(user.getCredentials().getRole())) {
            roles.add(new SimpleGrantedAuthority("ADMIN"));
        }
        roles.add(new SimpleGrantedAuthority("USER"));
        return roles;
    }

    public long getId() {
        return user.getId();
    }

    @Override
    public String getPassword() {
        return user.getCredentials().getPassword();
    }

    @Override
    public String getUsername() {
        return user.getCredentials().getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
