package com.spice.smsotpms.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spice.smsotpms.dto.UserDto;
import com.spice.smsotpms.entity.SMS;
import com.spice.smsotpms.entity.User;
import com.spice.smsotpms.error.MobileNumberNotFoundException;
import com.spice.smsotpms.repository.UserRepository;
import com.spice.smsotpms.service.UserService;
import com.spice.smsotpms.utility.GenericResponse;
import com.spice.smsotpms.utility.Library;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;
    
    //private UserMapper mapper;
    	
	/*
	 * @Autowired private AuthenticationManager authenticationManager;
	 * 
	 * @Autowired private TokenProvider jwtTokenUtil;
	 */
	
	private static final long OTP_VALID_DURATION = 3 * 60 * 1000;

    

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepo.findAll().iterator().forEachRemaining(list::add);
        return userRepo.findAll();
    }

    public User findOne(String mobileNo) {
        return userRepo.findByUsername(mobileNo);
    }
 
	public GenericResponse generateOtp(UserDto otp) throws Exception {		 
		User userOtp = userRepo.findByMobile(otp.getMobileNo()).orElseThrow(() -> new MobileNumberNotFoundException("mobile number not found"));
		
		SMS sms = new SMS();
		if(isOTPRequired(userOtp)) {
			String OTP = RandomString.make(4);
			userOtp.setPassword(OTP);
			userOtp.setOtpReqTime(new Date());
			userRepo.save(userOtp);
			sms.setMessage(OTP);
			sms.setTo(userOtp.getUsername());
		}else {
			sms.setMessage(userOtp.getPassword());
			sms.setTo(otp.getMobileNo());
		}
		Object obj = userOtp;
		GenericResponse genericResponse=Library.getSuccess(obj,"Record Process success");
		return genericResponse;
	}
	
	public boolean isOTPRequired(User userOtp) {
        if (userOtp.getPassword() == null) {
            return true;
        }
         
        long currentTimeInMillis = System.currentTimeMillis();
        long otpRequestedTimeInMillis = userOtp.getOtpReqTime().getTime();
         
        if (otpRequestedTimeInMillis + OTP_VALID_DURATION < currentTimeInMillis) {            
            return true;
        }
         
        return false;
    }
	
	public GenericResponse validateOtp(User otp) throws Exception{
		GenericResponse response = null;
		User userOtp = userRepo.findByMobile(otp.getUsername()).orElseThrow(() -> new MobileNumberNotFoundException("mobile number not found"));
		/*
		 * if(userOtp.getOneTimePassword().equals(userOtp.getOneTimePassword())) { final
		 * Authentication authentication = authenticationManager.authenticate( new
		 * UsernamePasswordAuthenticationToken( otp.getMobileNo(),
		 * otp.getOneTimePassword() ) );
		 * SecurityContextHolder.getContext().setAuthentication(authentication); final
		 * String token = jwtTokenUtil.generateToken(authentication); response=
		 * Library.getSuccess(new AuthToken(token), "token generated"); return response;
		 * }
		 */
		return response;
	}
}
