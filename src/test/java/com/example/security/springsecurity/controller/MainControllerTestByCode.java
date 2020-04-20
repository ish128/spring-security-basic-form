package com.example.security.springsecurity.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.anonymous;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class MainControllerTestByCode {

  @Autowired
  private MockMvc mockMvc;


  @Test
  public void 인덱스에_익명사용자로_접근하는_경우() throws Exception {

    mockMvc.perform(get("/").with(anonymous()))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  public void 인덱스에_일반사용자로_접근하는_경우() throws Exception {

    mockMvc.perform(get("/").with(user("ish128").roles("USER")))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  public void 관리자사이트에_일반사용자로_접근하는_경우() throws Exception {

    mockMvc.perform(get("/admin").with(user("ish128").roles("USER")))
        .andDo(print())
        .andExpect(status().isForbidden());
  }


  @Test
  public void 관리자사이트에_관리자로_접근하는_경우() throws Exception {

    mockMvc.perform(get("/admin").with(user("ish128").roles("ADMIN")))
        .andDo(print())
        .andExpect(status().isOk());
  }
}