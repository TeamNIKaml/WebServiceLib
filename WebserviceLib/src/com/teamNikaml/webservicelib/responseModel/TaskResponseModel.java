package com.teamNikaml.webservicelib.responseModel;

import java.util.ArrayList;
import java.util.List;

import com.teamNikaml.webservicelib.model.TaskList;

public class TaskResponseModel {
	
	private String status,status_message;
	private List<TaskList> taskList  = new ArrayList<TaskList>() ;
	
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

	

	
	
	public List<TaskList> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<TaskList> taskList) {
		this.taskList = taskList;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "status:"+status+" status_message:"+status_message+" taskResponseList:"+taskList;
	}
	
	
	

	

}
