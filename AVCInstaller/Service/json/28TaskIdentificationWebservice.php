<?php
		
		require_once 'Response.php';
		require_once 'LogFile.php';
		require_once 'TaskIdentificationModel.php';
		
		

			if(isset($_POST['userKey']))	
			{	
			writefile($_POST['userKey'],$_POST['requestKeyword']);

			$data = array();
			
			$id = array("1", "2", "3", "4","5");
			$name = array("Level1", "Level2", "Level3", "Level4","Other");
			
			
			for($i=0;$i<5;$i++)
			{
				$taskIdentificationModel = new TaskIdentificationModel($id[$i],$name[$i]);
				$data[$i] = $taskIdentificationModel;
				
			}
			
			
			echo Response::TaskIdentificationResponse(200,"Sucess",$data);	
			}
			else
			{
			writefile("Invalid","Invalid");
			
			//$data[0] = "invalid";
			$data = array();
			
		
			
			$id = array("1", "2", "3", "4","5");
			$name = array("Level1", "Level2", "Level3", "Level4","Other");
			
			
			for($i=0;$i<5;$i++)
			{
				$taskIdentificationModel = new TaskIdentificationModel($id[$i],$name[$i]);
				$data[$i] = $taskIdentificationModel;
				
			}
			echo  Response::TaskIdentificationResponse(500,"WebService Errror",$data);	
			}
			
			function writefile($userKey,$requestKeyword)
			{
			
			$data ="\t #28 Task Identification WebService \tuserKey: ".$userKey."\trequestKeyword: ".$requestKeyword;
			Logfile::writelog($data);
			
			}