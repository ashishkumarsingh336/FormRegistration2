package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="USER_REGISTRATION1")
public class UserRegistration {
	@Id
	@GeneratedValue
 private Integer id;
 private String fName;
 private String lName;
 private String email;
 private Long phNo;
 private String dob;
 private String gender;
 private String country;
 private String state;
 private String city;
 private String status;
 private String pwd;
 
  	
}
