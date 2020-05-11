package com.example.security.springsecurity.account;

import com.example.security.springsecurity.account.Account;
import com.example.security.springsecurity.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestUserGeneratorController {

private final AccountService accountService;

  @GetMapping("/test/user/{role}/{username}/{password}")
  public Account generator(@ModelAttribute Account account){
    return accountService.registerTestUser(account);
  }
}
