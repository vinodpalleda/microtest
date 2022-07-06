package com.spice.smsotpms.service;

import java.util.List;

import com.spice.smsotpms.dto.UserDto;
import com.spice.smsotpms.entity.User;
import com.spice.smsotpms.utility.GenericResponse;


public interface UserService {
    List<User> findAll();
    User findOne(String username);
	GenericResponse generateOtp(UserDto otp) throws Exception;
	GenericResponse validateOtp(User otp) throws Exception;
}
