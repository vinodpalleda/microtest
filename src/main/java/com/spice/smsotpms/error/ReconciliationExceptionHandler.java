package com.spice.smsotpms.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spice.smsotpms.constant.MessageConstant;
import com.spice.smsotpms.utility.GenericResponse;
import com.spice.smsotpms.utility.ResponseHeaderUtility;

@ControllerAdvice
public class ReconciliationExceptionHandler {

	@ExceptionHandler(value = {MobileNumberNotFoundException.class})
	public ResponseEntity<Object> mobileNoNotFound(HttpServletRequest request, MobileNumberNotFoundException ex){
		GenericResponse genericResponse = getResponse(MessageConstant.defaultErrorStatus, MessageConstant.defaultErrorCode,
				MessageConstant.mobileNumberNotFound, MessageConstant.mobileNumberNotFound, MessageConstant.defaultUserdata);
		
	    return new ResponseEntity<>(genericResponse, ResponseHeaderUtility.HttpHeadersConfig(),HttpStatus.OK);
	}
	
	private GenericResponse getResponse(String status, String errorCode, String errorMesg, String erroDesc,
			Object userData) {
		GenericResponse objGenericResponse = new GenericResponse();
		objGenericResponse.setStatus(status);
		objGenericResponse.setErrorCode(errorCode);
		objGenericResponse.setErrorDescription(errorMesg);
		objGenericResponse.setUserDisplayMesg(erroDesc);
		objGenericResponse.setData(userData);
		return objGenericResponse;
	}
}