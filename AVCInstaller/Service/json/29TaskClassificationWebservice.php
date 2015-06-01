<?php
		
		require_once 'Response.php';
		require_once 'LogFile.php';
		require_once 'TaskClassificationModel.php';
		
		

			if(isset($_POST['userKey']))	
			{	
			writefile($_POST['userKey'],$_POST['requestKeyword']);

			$data = array();
			
			$id = array("1", "2", "3", "4");
			$name = array("Level1", "Level2", "Level3", "Level4");
			
			
			for($i=0;$i<4;$i++)
			{
				$taskClassificationModel = new TaskClassificationModel($id[$i],$name[$i]);
				$data[$i] = $taskClassificationModel;
				
			}
			
			
			echo Response::TaskClassificationResponse(200,"Sucess",$data);	
			}
			else
			{
			writefile("Invalid","Invalid");
			
			//$data[0] = "invalid";
			$data = array();
			
		
			
			$id = array("1", "2", "3", "4");
			$name = array("Level1", "Level2", "Level3", "Level4");
			
			
			for($i=0;$i<4;$i++)
			{
				$taskClassificationModel = new TaskClassificationModel($id[$i],$name[$i]);
				$data[$i] = $taskClassificationModel;
				
			}
			echo  Response::TaskClassificationResponse(500,"WebService Errror",$data);	
			}
			
			function writefile($userKey,$requestKeyword)
			{
			
			$data ="\t #29 Task Classification WebService \tuserKey: ".$userKey."\trequestKeyword: ".$requestKeyword;
			Logfile::writelog($data);
			
			}