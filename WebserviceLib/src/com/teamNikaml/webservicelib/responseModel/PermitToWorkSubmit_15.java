package com.teamNikaml.webservicelib.responseModel;

public class PermitToWorkSubmit_15 {
	
	
	private String status,status_message;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus_message() {
		return status_message;
	}

	public void setStatus_message(String status_message) {
		this.status_message = status_message;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "status:"+status+"status_message:"+status_message;
	}

}
