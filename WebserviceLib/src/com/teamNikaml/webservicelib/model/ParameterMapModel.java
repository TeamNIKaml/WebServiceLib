package com.teamNikaml.webservicelib.model;

import java.util.HashMap;
import java.util.Map;

public class ParameterMapModel {

	private Map<String, String> loginMap = new HashMap<String, String>();

	private Map<String, String> taskMap = new HashMap<String, String>();
	
	private Map<String, String> taskDetailsMap = new HashMap<String, String>();
	
	private Map<String, String> asbestosDataMap = new HashMap<String, String>();
	private Map<String, String> asbestosFileMap = new HashMap<String, String>();

	public Map<String, String> getAsbestosDataMap() {
		return asbestosDataMap;
	}
	public void setAsbestosDataMap() {
		asbestosDataMap.put("userKey", "6bc459e0cf4082e7f49a56ebea0ae2d7d");
		asbestosDataMap.put("requestKeyword", "Asbestos Register");
	}
	public Map<String, String> getAsbestosFileMap() {
		return asbestosFileMap;
	}
	public void setAsbestosFileMap(String path) {
		asbestosDataMap.put("uploaded_file", path);
		//asbestosDataMap.put("requestKeyword", "Asbestos Register");
	}
	public Map<String, String> getTaskDetailsMap() {
		return taskDetailsMap;
	}
	public void setTaskDetailsMap() {
		
		taskDetailsMap.put("userKey", "6bc459e0cf4082e7f49a56ebea0ae2d7d");
		taskDetailsMap.put("taskId", "1");
		taskDetailsMap.put("requestKeyword", "taskDetails");
		
	}
	public Map<String, String> getTaskMap() {
		return taskMap;
	}
	//taskId
	public void setTaskMap() {
		//this.taskMap = taskMap;
		taskMap.put("userKey", "6bc459e0cf4082e7f49a56ebea0ae2d7d");
		taskMap.put("requestKeyword", "myTasks");
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
