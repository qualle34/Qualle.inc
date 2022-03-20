package com.inc.qualle.config;

import com.inc.qualle.controller.handler.AuthenticationHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder encoder;
    private final AuthenticationHandler handler;
    private final UserDetailsService userDetailsServiceImpl;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
                .disable()
            .authorizeRequests()
                .antMatchers("/", "/home", "/game/**", "/games/**", "/about", "/contacts/**", "/error", "/service").permitAll()
                .antMatchers("/js/**", "/css/**", "/img/**").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/test").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .successHandler(handler)
                .failureHandler(handler)
            .and()
                .logout()
                .permitAll()
                .logoutSuccessHandler(handler);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(encoder);
    }
}
