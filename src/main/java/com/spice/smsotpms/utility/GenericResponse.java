package com.spice.smsotpms.utility;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	/** e@Datarror code. 0 if success else unique error code value */

	private String status;  // s and f
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public String getUserDisplayMesg() {
		return userDisplayMesg;
	}
	public void setUserDisplayMesg(String userDisplayMesg) {
		this.userDisplayMesg = userDisplayMesg;
	}
	public Object getResponseContent() {
		return responseContent;
	}
	public void setResponseContent(Object responseContent) {
		this.responseContent = responseContent;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private String errorCode;  // 00 
	private String errorDescription;  //success /failure
	private String userDisplayMesg;  //User customMeaasge
	private Object responseContent;
	
	private String statusCode;  // 00 
	private String message; 
	private Object data;
	
	
/*	private String status;  // s and f
	private Integer errorCode;  // 00 
	private String errorDescription;  //success /failure
	private String userDisplayMesg;  //User customMeaasge
	private Object responseContent;*/
	
	
	
}