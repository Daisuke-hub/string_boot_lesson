package com.example.demo.form;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Data
public class UserForm {

  @Size(min = 1, max = 200)
  private String name;

  @Size(min = 1, max = 200)
  @Email
  private String email; 
}