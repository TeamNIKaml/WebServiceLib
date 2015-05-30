package com.teamNikaml.webservicelib.model;

public class Login {
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "status:"+status+" statusMessage:"+status_message+" userKey:"+userKey+" designation:"+designation+" pgmId:"+pgmId;
	}
	public String getStatus_message() {
		return status_message;
	}
	public void setStatus_message(String status_message) {
		this.status_message = status_message;
	}
	private String status,status_message;
	private String userKey,designation,pgmId;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPgmId() {
		return pgmId;
	}
	public void setPgmId(String pgmId) {
		this.pgmId = pgmId;
	}

}
