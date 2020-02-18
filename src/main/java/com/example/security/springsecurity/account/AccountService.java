package com.example.security.springsecurity.account;

import lombok.RequiredArgsConstructor;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
@Transactional
public class AccountService implements UserDetailsService {

  private final AccountDao accountDao;

  private final PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return accountDao.findByUsername(username)
        .map(account ->
            User.builder()
            .username(account.getUsername())
            .password(account.getPassword())
            .roles(account.getRole())
                .build())
        .orElseThrow(()->new UsernameNotFoundException(username));
  }

  public Account registerTestUser(Account account){
    account.encodePassword(passwordEncoder);
    return accountDao.save(account);
  }
}
