package com.example.security.springsecurity.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
   http.authorizeRequests()
       .mvcMatchers("/","/info").permitAll()
       .mvcMatchers("/admin").hasRole("ADMIN")
       .anyRequest().authenticated()
       .and().
       formLogin()
       .and()
       .httpBasic();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("ish128").password("{noop}123").roles("USER")
        .and().withUser("admin").password("{noop}111").roles("ADMIN");
  }
}
