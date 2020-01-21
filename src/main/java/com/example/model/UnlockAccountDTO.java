package com.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UnlockAccountDTO {
 
 private String email;
 private String tempPwd;
 private String newPwd;
 private String confirmPwd;
 
  	
}
