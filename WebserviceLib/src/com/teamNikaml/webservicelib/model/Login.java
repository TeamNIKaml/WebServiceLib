package com.teamNikaml.webservicelib.model;

public class Login {
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "status:"+status+" statusMessage:"+statusMessage+" userKey:"+userKey+" designation:"+designation+" pgmId:"+pgmId;
	}
	private String status,statusMessage;
	private String userKey,designation,pgmId;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
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
