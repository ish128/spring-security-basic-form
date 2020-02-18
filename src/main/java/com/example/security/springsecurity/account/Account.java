package com.example.security.springsecurity.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Account {

  @Id @GeneratedValue
  private Integer id;

  @Column(unique = true)
  private String username;
  private String password;
  private String role;

  public void encodePassword(PasswordEncoder passwordEncoder){
    password = passwordEncoder.encode(password);
  }
}
