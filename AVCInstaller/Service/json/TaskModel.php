<?php 

 class TaskModel
		 {
			var $taskId,$projectId,$projectName,$siteName,$startDate,$endDate,$latitude,$longitude,$postcode;
			
			
			function __construct($taskId,$projectId,$projectName,$siteName,$startDate,$endDate,$latitude,$longitude,$postcode)
			{
				 $this->taskId = $taskId;
				 $this->projectId = $projectId;
				 $this->projectName = $projectName;
				 $this->siteName = $siteName;
				 $this->startDate = $startDate;
				 $this->endDate = $endDate;
				  $this->latitude = $latitude;
				 $this->longitude = $longitude;
				 $this->postcode = $postcode;
			}
		}

?>