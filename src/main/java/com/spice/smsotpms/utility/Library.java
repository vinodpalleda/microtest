package com.spice.smsotpms.utility;

public class Library {
	public static String getAmountConvertFromPaiseToRs(String strValue) {
		if (strValue != null && !strValue.equals("")) {
			return "" + Float.parseFloat(strValue.trim()) / 100;
		}
		return "0";
	}

	public static Float getFloatValue(String strValue) {
		if (strValue != null && !strValue.equals("")) {
			try {
				return Float.parseFloat(strValue.trim());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return 0f;
	}

	public static int getIntValue(String strValue) {
		if (strValue != null && !strValue.equals("")) {
			try {
				return Integer.parseInt(strValue.trim());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return 0;
	}

	public static String trimAndRemoveSpecialCharacter(String str) throws Exception {
		if (str != null && !str.equals("")) {
			str = str.trim();
		}
		if (str != null) {
			str = str.replaceAll("'", "");
		}
		return str;
	}

	public static String toLowerCase(String str) throws Exception {
		if (str != null && !str.equals("")) {
			str = str.toLowerCase().trim();
		}
		return str;
	}

	

	

	public static GenericResponse getFailure(String msg, Object obj) throws Exception {
		GenericResponse GenericResponse = new GenericResponse();
		if (obj != null) {
			GenericResponse.setData(obj);
		}
		GenericResponse.setErrorCode("1");
		GenericResponse.setStatus("f");
		GenericResponse.setUserDisplayMesg(msg);
		return GenericResponse;
	}

	public static GenericResponse getSuccess(Object obj,String msg) throws Exception {
		GenericResponse GenericResponse = new GenericResponse();
		GenericResponse.setData(obj);
		GenericResponse.setErrorCode("0");
		GenericResponse.setStatus("s");
		GenericResponse.setUserDisplayMesg("Success");
		GenericResponse.setUserDisplayMesg(msg);

		return GenericResponse;
	}

}
