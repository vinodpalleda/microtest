package com.spice.smsotpms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spice.smsotpms.dto.UserDto;
import com.spice.smsotpms.entity.User;
import com.spice.smsotpms.service.UserService;
import com.spice.smsotpms.utility.ResponseHeaderUtility;

@RestController
public class SMSController {
	
	@Autowired
	private UserService smsService;
		
	@PostMapping("/generateotp")
	public ResponseEntity<Object> generateOtp(@RequestBody UserDto otp) throws Exception{ 
		Object obj = smsService.generateOtp(otp);
		return new ResponseEntity<>(obj,HttpStatus.CREATED) ;
	}
	
	@PostMapping("/validateotp")
	public ResponseEntity<Object> validateOtp(@RequestBody User otp) throws Exception{
		Object object = smsService.validateOtp(otp);
		return new ResponseEntity<Object>(object,ResponseHeaderUtility.HttpHeadersConfig(),HttpStatus.OK);
	}
	
}
