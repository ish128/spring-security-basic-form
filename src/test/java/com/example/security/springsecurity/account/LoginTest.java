package com.example.security.springsecurity.account;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class LoginTest {

  @Autowired
  private AccountService accountService;

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void login_success()throws Exception{
    String username="ish129";
    String password ="111";
    createUser(username,password);

    mockMvc.perform(formLogin().user(username).password(password))
        .andDo(print())
        .andExpect(authenticated());

  }

  @Test
  public void login_fail()throws Exception{
    String username="ish129";
    String password ="111";
    createUser(username,password);

    mockMvc.perform(formLogin().user(username).password("112"))
        .andDo(print())
        .andExpect(unauthenticated());

  }

  private void createUser(String username, String password){
    Account account = new Account();
    account.setUsername(username);
    account.setPassword(password);
    account.setRole("USER");

    accountService.registerTestUser(account);

  }

}
