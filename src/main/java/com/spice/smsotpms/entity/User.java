package com.spice.smsotpms.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	private static final long OTP_VALID_DURATION = 3 * 60 * 1000;

	@Id
	@Column(name = "mobile_no")
	private String username;
	
	@Column(name = "one_time_password")
	private String password;
	
	@Column(name = "otp_req_time")
	private Date otpReqTime;
	
	@Column(name = "active")
	private int active;
	
	@Column(name = "email")
	private String email;

	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", 
    joinColumns = { @JoinColumn(referencedColumnName="mobile_no") }, 
    inverseJoinColumns = { @JoinColumn(referencedColumnName="name") })
    private Set<Role> roles;
		
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getOtpReqTime() {
		return otpReqTime;
	}

	public void setOtpReqTime(Date otpReqTime) {
		this.otpReqTime = otpReqTime;
	}
	
	public int isActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getActive() {
		return active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public boolean isOTPRequired() {
        if (this.getPassword() == null) {
            return false;
        }
         
        long currentTimeInMillis = System.currentTimeMillis();
        long otpRequestedTimeInMillis = this.otpReqTime.getTime();
         
        if (otpRequestedTimeInMillis + OTP_VALID_DURATION < currentTimeInMillis) {
            return false;
        }
         
        return true;
    }
}
