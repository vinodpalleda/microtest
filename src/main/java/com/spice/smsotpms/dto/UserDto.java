package com.spice.smsotpms.dto;

import java.util.Date;
import java.util.Set;

import com.spice.smsotpms.entity.Role;

public class UserDto {
private String mobileNo;
	
	private String otp;
	
	private Date otpReqTime;
	
	private Set<Role> roles;

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Date getOtpReqTime() {
		return otpReqTime;
	}

	public void setOtpReqTime(Date otpReqTime) {
		this.otpReqTime = otpReqTime;
	}
}
