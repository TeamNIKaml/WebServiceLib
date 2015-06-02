package com.teamNikaml.webservicelib.responseModel;

import java.util.ArrayList;
import java.util.List;

public class TaskDetailsResponseModel {

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "status : "+status+" status_message: "+status_message+" taskDetails: "+taskDetails+" assignedResources: "+assignedResources;
	}

	private String status, status_message;
	private TaskDetails taskDetails;
	public TaskDetails getTaskDetails() {
		return taskDetails;
	}

	public void setTaskDetails(Object taskDetailsObject) {
		this.taskDetails =(TaskDetails) taskDetailsObject;
	}

	private List<AssignedResources> assignedResources = new ArrayList<AssignedResources>();

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



	public List<AssignedResources> getAssignedResources() {
		return assignedResources;
	}

	public void setAssignedResources(List<Object> objectList) {

		for (int i = 0; i < objectList.size(); i++) {
			AssignedResources assignedResourcesData = (AssignedResources) objectList
					.get(i);
			assignedResources.add(assignedResourcesData);
		}

		// this.assignedResources = assignedResources;
	}

	public static class TaskDetails {

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "taskId: "+taskId+" projectId: "+ projectId+" projectName:"+ projectName+" customerName:"+ customerName+
					" siteName:"+ siteName+"contactPerson:"+contactPerson+" contactNumber:"+ contactNumber+
					" teamLead:"+ teamLead+" siteNumber:"+ siteNumber+" street: "+street+" streetNumber:"+streetNumber+
					"city:"+ city+" country :"+ country+" postalCode:"+ postalCode;
		}

		private String taskId, projectId, projectName, customerName, siteName,
				contactPerson, contactNumber, teamLead, siteNumber;
		private String street, streetNumber, city, country, postalCode;

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

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getSiteName() {
			return siteName;
		}

		public void setSiteName(String siteName) {
			this.siteName = siteName;
		}

		public String getContactPerson() {
			return contactPerson;
		}

		public void setContactPerson(String contactPerson) {
			this.contactPerson = contactPerson;
		}

		public String getContactNumber() {
			return contactNumber;
		}

		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}

		public String getTeamLead() {
			return teamLead;
		}

		public void setTeamLead(String teamLead) {
			this.teamLead = teamLead;
		}

		public String getSiteNumber() {
			return siteNumber;
		}

		public void setSiteNumber(String siteNumber) {
			this.siteNumber = siteNumber;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getStreetNumber() {
			return streetNumber;
		}

		public void setStreetNumber(String streetNumber) {
			this.streetNumber = streetNumber;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getPostalCode() {
			return postalCode;
		}

		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}

		public TaskDetails() {

		}

	}

	public static class AssignedResources {

		
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "name: "+name+" resourceURL: "+resourceURL;
		}

		private String name, resourceURL;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getResourceURL() {
			return resourceURL;
		}

		public void setResourceURL(String resourceURL) {
			this.resourceURL = resourceURL;
		}

		public AssignedResources() {

		}

	}

}
