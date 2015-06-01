package com.teamNikaml.webservicelib.responseModel;

import java.util.ArrayList;
import java.util.List;

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

	public void setTaskList(List<Object> objectList) {
		
		for(int i=0;i<objectList.size();i++)
		{
		TaskList task =(TaskList)objectList.get(i);
		taskList.add(task);
		}
		
		
		//this.taskList = taskList;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "status:"+status+" status_message:"+status_message+" taskResponseList:"+taskList;
	}
	
	
	public static class TaskList {
		
		
		public TaskList(){}
		

		private String taskId,projectId,projectName,siteName,startDate,endDate,latitude,longitude,postcode;

		public String getTaskId() {
			return taskId;
		}

		public void setTaskId(String taskId) {
			this.taskId = taskId;
		}

		public String getProjectId() {
			return projectId;
		}

		public void setProjectId(String projectId) {
			this.projectId = projectId;
		}

		public String getProjectName() {
			return projectName;
		}

		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}

		public String getSiteName() {
			return siteName;
		}

		public void setSiteName(String siteName) {
			this.siteName = siteName;
		}

		public String getStartDate() {
			return startDate;
		}

		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}

		public String getEndDate() {
			return endDate;
		}

		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}

		public String getLatitude() {
			return latitude;
		}

		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}

		public String getLongitude() {
			return longitude;
		}

		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}

		public String getPostcode() {
			return postcode;
		}

		public void setPostcode(String postcode) {
			this.postcode = postcode;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "taskId:"+taskId+" projectId:"+projectId+" projectName:"+projectName+" siteName :"+siteName+" startDate:"+startDate+
					" endDate :"+endDate+" latitude :"+latitude+" longitude :"+longitude+" postcode : "+postcode;
		}
	
	
	}

	

}
