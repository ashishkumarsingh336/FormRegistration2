package com.example.service;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.UserRegistration;
import com.example.mail.EmailUtils;
import com.example.model.ForgotPwdDTO;
import com.example.model.UnlockAccountDTO;
import com.example.model.UserLoginDTO;
import com.example.model.UserRegDTO;
import com.example.random.RandomPassword;
import com.example.repository.UserRegistrationRepository;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
	@Autowired
	private UserRegistrationRepository userRegistrationRepo;

	@Autowired
	private RandomPassword randomPassword;

	@Autowired
	private EmailUtils emailUtils;

	/**
	 * save the form record
	 * generate random password
	 * set Account status also
	 */

	@Override
	public boolean save(UserRegDTO dto) throws Exception {

		UserRegistration entity = new UserRegistration();

		BeanUtils.copyProperties(dto, entity);

		String tempPwd = tempPwd(7);
		entity.setPwd(tempPwd);
		entity.setStatus("Locked");

		UserRegistration saveEntity = userRegistrationRepo.save(entity);
		if (saveEntity.getId() > 0)
			// fetchEmailAndPwd(saveEntity);
			if (saveEntity.getId() > 0)
				sendMailToClient(saveEntity);
		return saveEntity.getId() > 0;
	}
	
    /**
     * generate random password
     */
	@Override
	public String tempPwd(int cnt) {
		String randomAlphaNumeric = randomPassword.getAlphaNumeric(cnt);
		return randomAlphaNumeric;
	}
     
	/**
	 * read file data from file 
	 */
	@Override
	public String readMailFromTextFile(UserRegistration userRegBo) throws Exception {
		// read file as String in Java SE 6 and lower version
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader("TextBody.txt"));
		String line = br.readLine();

		while (line != null) {
			if (line.contains("${toName}")) {
				line = line.replace("${toName}", userRegBo.getFName());
			} else if (line.contains("${pwd}")) {
				line = line.replace("${pwd}", userRegBo.getPwd());
			} else if (line.contains("${signupEmail}")) {
				line = line.replace("${signupEmail}", userRegBo.getEmail());
			}
			sb.append(line).append("\n");
			line = br.readLine();
		}

		String fileAsString = sb.toString();
		return fileAsString;
	}
    
	/**
	 * generate mail to recipients
	 */
	@Override
	public void sendMailToClient(UserRegistration userRegBo) throws Exception {
		String body = readMailFromTextFile(userRegBo);
		emailUtils.sendMail(userRegBo.getEmail(), "Register Login Account", body);

	}
   /**
    * get email and password 
    * unlock the status
    */
	@Override
	public boolean fetchEmailAndPwd(UnlockAccountDTO dto) {
		boolean flag = false;

		UserRegistration entity = userRegistrationRepo.findByEmailAndPassword(dto.getEmail(), dto.getTempPwd());
		if (entity != null) {
			if (entity.getId() > 0 && "Locked".equals(entity.getStatus())) {
				entity.setPwd(dto.getNewPwd());
				entity.setStatus("Unlocked");
				entity = userRegistrationRepo.save(entity);
				flag = true;
			} // if

		} // if

		return flag;
	}
    
	/**
	 * login user account if status is unlock
	 */
	@Override
	public String findEmailAndPwd(UserLoginDTO dto) {
		boolean flag = false;

		UserRegistration entity = userRegistrationRepo.findByEmailAndPassword(dto.getEmail(), dto.getPazzword());
		if (entity != null) {
			if ("Locked".equals(entity.getStatus()))
				return "your account is locked please unlock it.....";
			else if ("Unlocked".equals(entity.getStatus()))
				return "Log In";
		}
		return "your email id or password are not correct. Try again.... ";
	}

	@Override
	public String fetchEmail(ForgotPwdDTO dto) throws Exception {

		UserRegistration entity = userRegistrationRepo.findByEmail(dto.getEmail());
		if (entity != null) {
			if ("Locked".equals(entity.getStatus())) {
				return "Error: your account is locked ";
			}
			else {
				sendMailToClient(entity);
				return "Password send successfully......";
			}
	
		}
		return "Please enter corrrect mail Id ";
	}
}
