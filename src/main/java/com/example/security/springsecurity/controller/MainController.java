package com.example.security.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@Controller
public class MainController {


  @GetMapping("/index")
  public String index(Model model, Principal principal){
    if(principal==null){
      model.addAttribute("message","Spring Security");
    }else {
      model.addAttribute("message","Spring Security, Hello "+principal.getName());
    }

      return "index";

  }

  @GetMapping("/info")
  public String info(Model model){
//    model.addAttribute("message","ish128");
    return "info";

  }

  @GetMapping("/dashboard")
  public String dashboard(Model model, Principal principal   ){
    model.addAttribute("message","Hello, "+ principal.getName());
    return "dashboard";

  }
  @GetMapping("/admin")
  public String admin(Model model, Principal principal){
    model.addAttribute("message","Hello Admin, " + principal.getName());
    return "admin";

  }
}
