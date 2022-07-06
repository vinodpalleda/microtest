package com.spice.smsotpms.error;

public class MobileNumberNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MobileNumberNotFoundException() {
		super();
	}

	public MobileNumberNotFoundException(String msg){
		super(msg);
	}
	
	public MobileNumberNotFoundException(String msg, Throwable th) {
		super(msg,th);
	}
	
	public MobileNumberNotFoundException(Throwable th) {
		super(th);
	}
}
