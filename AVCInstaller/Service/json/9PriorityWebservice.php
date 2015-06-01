<?php
		
		require_once 'Response.php';
		require_once 'LogFile.php';
		require_once 'ProirityModel.php';
		
		

			if(isset($_POST['userKey']))	
			{	
			writefile($_POST['userKey'],$_POST['requestKeyword']);

			$data = array();
			
			$priorityId = array("1", "2", "3", "4");
			$name = array("low", "medium", "high", "critical");
			
			
			for($i=0;$i<4;$i++)
			{
				$prorrity = new ProirityModel($priorityId[$i],$name[$i]);
				$data[$i] = $prorrity;
				
			}
			
			
			echo Response::PriorityListResponse(200,"Sucess",$data);	
			}
			else
			{
			writefile("Invalid","Invalid");
			
			//$data[0] = "invalid";
			$data = array();
			
		
			
			$priorityId = array("1", "2", "3", "4");
			$name = array("low", "medium", "high", "critical");
			
			
			for($i=0;$i<4;$i++)
			{
				$prorrity = new ProirityModel($priorityId[$i],$name[$i]);
				$data[$i] = $prorrity;
				
			}
			echo  Response::PriorityListResponse(500,"WebService Errror",$data);	
			}
			
			function writefile($userKey,$requestKeyword)
			{
			
			$data ="\t #9 Priority WebService \tuserKey: ".$userKey."\trequestKeyword: ".$requestKeyword;
			Logfile::writelog($data);
			
			}