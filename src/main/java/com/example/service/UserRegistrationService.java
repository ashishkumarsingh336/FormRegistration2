package com.example.service;

import com.example.entity.UserRegistration;
import com.example.model.ForgotPwdDTO;
import com.example.model.UnlockAccountDTO;
import com.example.model.UserLoginDTO;
import com.example.model.UserRegDTO;

public interface UserRegistrationService {
	
	public boolean save(UserRegDTO dto) throws Exception;

	public String tempPwd(int cnt);

	public void sendMailToClient(UserRegistration userRegBO) throws Exception;

	public String readMailFromTextFile(UserRegistration userRegBo) throws Exception;
	
	public boolean fetchEmailAndPwd(UnlockAccountDTO dto);
	
	public String findEmailAndPwd(UserLoginDTO dto);
	
	public String fetchEmail(ForgotPwdDTO dto) throws Exception;
	
	

}
