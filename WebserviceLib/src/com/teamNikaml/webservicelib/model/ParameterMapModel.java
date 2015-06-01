package com.teamNikaml.webservicelib.model;

import java.util.HashMap;
import java.util.Map;

public class ParameterMapModel {

	private Map<String, String> loginMap = new HashMap<String, String>();

	private Map<String, String> taskMap = new HashMap<String, String>();

	public Map<String, String> getTaskMap() {
		return taskMap;
	}

	public void setTaskMap() {
		//this.taskMap = taskMap;
	}

	public void setLoginMap() {
		loginMap.put("emailId", "abc@hm.cc");
		loginMap.put("password", "loginpassword");
		loginMap.put("requestKeyword", "Login");
	}

	public Map<String, String> getLoginMap() {
		return loginMap;
	}

}
