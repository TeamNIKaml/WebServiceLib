<?php 
 class TaskDetailsModel
		 {
			var $taskId,$projectId,$projectName,$customerName,$siteName,$contactPerson,$contactNumber;
			 var $teamLead,$siteNumber,$street,$streetNumber,$city,$country,$postalCode;
			
			
			function __construct($taskId,$projectId,$projectName,$customerName,$siteName,$contactPerson,$contactNumber,$teamLead,$siteNumber,$street,$streetNumber,$city,$country,$postalCode)
			{
				 $this->taskId = $taskId;
				 $this->projectId = $projectId;
				 $this->projectName = $projectName;
				 $this->customerName = $customerName;
				 $this->siteName = $siteName;
				 $this->contactPerson = $contactPerson;
				 $this->contactNumber = $contactNumber;
				 $this->teamLead = $teamLead;
				 $this->siteNumber = $siteNumber;
				 $this->street = $street;
				 $this->streetNumber = $streetNumber;
				 $this->city = $city;
				 $this->country = $country;
				 $this->postalCode = $postalCode;
			}
		}

?>