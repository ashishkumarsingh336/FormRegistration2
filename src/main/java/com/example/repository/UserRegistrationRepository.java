package com.example.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.UserRegistration;

@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Integer> {
	@Transactional
   
	@Query("FROM UserRegistration WHERE email=:email AND pwd=:pwd")
	public UserRegistration findByEmailAndPassword(String email,String pwd);
	
	public UserRegistration findByEmail(String email);
	
}
