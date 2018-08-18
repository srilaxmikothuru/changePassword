package com.capgemini.capstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Authentication;
import com.capgemini.capstore.repo.CustomerRepo;
@Component
public class CustomerServicesImpl implements CustomerServices {

	@Autowired
	private CustomerRepo mrepo;


	@Override
	public void changePassword(String mobileNo, String password, String confirmPassword) {
		if(password.compareTo(confirmPassword) == 0 ) {
			Authentication auth = mrepo.findByMobileNo(mobileNo);
			if(auth == null)
				System.out.println("No User Found");
			else {
				String oldPassword = auth.getPassword();
				BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
				String encodedPassword = enc.encode(password);
				if(oldPassword.compareTo(encodedPassword)== 0) {
					System.out.println("NewPassword should not match with oldPassword");
				}
				else {
					auth.setPassword(encodedPassword);
				}
				mrepo.save(auth);
			}
		}
		else
			System.out.println("password and confirmPassword are not equal");

	}

}
