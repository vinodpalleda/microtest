package com.spice.smsotpms.utility;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class ResponseHeaderUtility {
	static HttpHeaders responseHeaders = null;

	ResponseHeaderUtility() {
		responseHeaders = new HttpHeaders();
		responseHeaders.set("content-type", "application/json");
	}

	public static HttpHeaders HttpHeadersConfig() {
		return responseHeaders;
	}

}
