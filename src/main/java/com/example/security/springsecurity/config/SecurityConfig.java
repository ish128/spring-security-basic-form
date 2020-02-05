package com.example.security.springsecurity.config;


import com.example.security.springsecurity.account.AccountService;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final AccountService accountService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
   http.authorizeRequests()
       .mvcMatchers("/","/info","/test/**").permitAll()
       .mvcMatchers("/admin").hasRole("ADMIN")
       .anyRequest().authenticated()
       .and().
       formLogin()
       .and()
       .httpBasic();
  }

}
