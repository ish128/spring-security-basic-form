package com.example.security.springsecurity.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@RequiredArgsConstructor
@Controller
public class SampleController {

    private final SampleService sampleService;

    @GetMapping("/sample")
    public String sample(Model model, Principal principal){
        sampleService.dashboard();
        return "sample";
    }
}
