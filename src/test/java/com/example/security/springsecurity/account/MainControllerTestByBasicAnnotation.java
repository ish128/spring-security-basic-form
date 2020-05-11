package com.example.security.springsecurity.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class MainControllerTestByBasicAnnotation {

  @Autowired
  private MockMvc mockMvc;


  @Test
  @WithAnonymousUser
  public void 인덱스에_익명사용자로_접근하는_경우() throws Exception {

    mockMvc.perform(get("/"))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  @WithMockUser(username = "ish128", roles = "USER")
  public void 인덱스에_일반사용자로_접근하는_경우() throws Exception {

    mockMvc.perform(get("/"))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  @WithMockUser(username = "ish128", roles = "USER")
  public void 관리자사이트에_일반사용자로_접근하는_경우() throws Exception {

    mockMvc.perform(get("/admin"))
        .andDo(print())
        .andExpect(status().isForbidden());
  }


  @Test
  @WithMockUser(username = "ish128", roles = "ADMIN")
  public void 관리자사이트에_관리자로_접근하는_경우() throws Exception {

    mockMvc.perform(get("/admin"))
        .andDo(print())
        .andExpect(status().isOk());
  }
}
