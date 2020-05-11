package com.example.security.springsecurity.sample;

import com.example.security.springsecurity.account.WithUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class SampleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @WithUser
    @Test
    public void sample() throws Exception {
        mockMvc.perform(get("/sample"))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
