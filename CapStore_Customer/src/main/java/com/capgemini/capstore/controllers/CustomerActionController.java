package com.capgemini.capstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.services.CustomerServices;

@RestController
public class CustomerActionController {

@Autowired
	private CustomerServices mservices;

	@RequestMapping(value="/changePassword", method=RequestMethod.POST)
    public void changePassword(@RequestParam("mobile_no") String mobileNo,@RequestParam("password") String password,@RequestParam("confirmPassword") String confirmPassword) {
    	
		mservices.changePassword(mobileNo, password, confirmPassword);
		
	}
	

}
