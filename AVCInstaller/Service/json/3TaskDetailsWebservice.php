<?php
		
		require_once 'Response.php';
		require_once 'LogFile.php';
		require_once 'TaskDetailsModel.php';
		require_once 'AssignedResourceModel.php';
		
		

			if(isset($_POST['userKey'])||isset($_POST['requestKeyword']))	
			{	
			writefile($_POST['userKey'],$_POST['requestKeyword'],$_POST['taskId']);

			$data = array();
			$assignedResourceData = array();
			
				$task = new TaskDetailsModel("101","21","Cobra","GiJoe","WhiteHouse","LadyJaa","911234568",
			          "Dwayne Johnson","no2","downtown","no21","WashingtonDc","USA","123456");
				
				
					$assignedResource = new AssignedResourceModel("Dialux output","http://www.eco-hubplatform.com/plan_files/688/Coryton%20Primary%20School.pdf");
					$assignedResourceData[0] = $assignedResource;
					
					$assignedResource = new AssignedResourceModel("Magic Plan output","http://www.eco-hubplatform.com/plan_files/688/Coryton%20Primary%20School.pdf");
					$assignedResourceData[1] = $assignedResource;
				
				$data[0] = $task;
				$data[1] =$assignedResourceData;
			
			
			
			echo Response::TaskDetailsResponse(200,"Sucess",$data);	
			}
			else
			{
			writefile("Invalid","Invalid","invalid");
			
			//$data[0] = "invalid";
			
				$task = new TaskDetailsModel("101","21","Cobra","GiJoe","WhiteHouse","LadyJaa","911234568",
			          "Dwayne Johnson","no2","downtown","no21","WashingtonDc","USA","123456");
				
				for($j=0;$j<2;$j++)
				{
					$assignedResource = new AssignedResourceModel("Dialux output","http://www.eco-hubplatform.com/plan_files/688/Coryton%20Primary%20School.pdf");
					$assignedResourceData[$j] = $assignedResource;
				}
				$data[0] = $task;
				$data[1] =$assignedResourceData;
				
			
			
			
			echo Response::TaskDetailsResponse(500,"WebserviceError",$data);		
			}
			
			function writefile($userKey,$requestKeyword,$taskId)
			{
			
			$data ="\t #3 Task Details WebService \tuserKey:".$userKey."\trequestKeyword :".$requestKeyword."\t taskId :".$taskId;
			Logfile::writelog($data);
			
			}
			
			
			
			
			