package com.teamNikaml.webservicelib.model;

import java.util.HashMap;
import java.util.Map;

public class ParameterMapModel {
	
	
 private Map<String, String> loginMap = new HashMap<String, String>();

	public Map<String, String> getLoginMap() {
		return loginMap;
	}

	public void setLoginMap() {
		loginMap.put("emailId", "abc@hm.cc");
		loginMap.put("password", "loginpassword");
		loginMap.put("requestKeyword", "Login");
	}
	
	
	
	

}
