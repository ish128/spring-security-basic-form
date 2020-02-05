package com.example.security.springsecurity.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountDao extends JpaRepository<Account, Integer> {

  Optional<Account> findByUsername(String username);
}
