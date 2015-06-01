<?php
		
		require_once 'Response.php';
		require_once 'LogFile.php';
		require_once 'TaskModel.php';
		
		

			if(isset($_POST['userKey'])||isset($_POST['requestKeyword']))	
			{	
			writefile($_POST['userKey'],$_POST['requestKeyword']);

			$data = array();
			
			$latitude = array("74.61453", "74.614564", "74.614661", "74.614784", "74.615058");
			$longitude = array("40.47307", "40.472985", "40.472743", "40.472387", "40.471677");
			$postcode = array("651223", "251633", "334455", "4455566", "7788899");
			
			$taskId = array("t1", "t2", "t3", "t4", "t5");
			$projectId = array("p1", "p2", "p3", "p4", "p5");
			$projectName = array("Avengers", "Game of Thrones", "SherLock", "Dexter", "Mentalist");
			$siteName = array("Newyork", "7Kingdom", "London", "USA", "California");
			$startDate = array("3-1-2014", "3-4-2015", "4-8-2014", "6-5-2010", "8-6-2011");
			$endDate = array("5-5-2014", "7-6-2015", "5-1-2015", "8-5-2015", "8-6-2015");
			
			for($i=0;$i<5;$i++)
			{
				$task = new TaskModel($taskId[$i],$projectId[$i],$projectName[$i],$siteName[$i],$startDate[$i],$endDate[$i],$latitude[$i],$longitude[$i],$postcode[$i]);
				$data[$i] = $task;
				
			}
			
			
			echo Response::TaskResponse(200,"Sucess",$data);	
			}
			else
			{
			writefile("Invalid","Invalid");
			
			//$data[0] = "invalid";
			$data = array();
			
		$latitude = array("74.61453", "74.614564", "74.614661", "74.614784", "74.615058");
			$longitude = array("40.47307", "40.472985", "40.472743", "40.472387", "40.471677");
			$postcode = array("651223", "251633", "334455", "4455566", "7788899");
			
			$taskId = array("t1", "t2", "t3", "t4", "t5");
			$projectId = array("p1", "p2", "p3", "p4", "p5");
			$projectName = array("Avengers", "Game of Thrones", "SherLock", "Dexter", "Mentalist");
			$siteName = array("Newyork", "7Kingdom", "London", "USA", "California");
			$startDate = array("3-1-2014", "3-4-2015", "4-8-2014", "6-5-2010", "8-6-2011");
			$endDate = array("5-5-2014", "7-6-2015", "5-1-2015", "8-5-2015", "8-6-2015");
			
			for($i=0;$i<5;$i++)
			{
				$task = new TaskModel($taskId[$i],$projectId[$i],$projectName[$i],$siteName[$i],$startDate[$i],$endDate[$i],$latitude[$i],$longitude[$i],$postcode[$i]);
				$data[$i] = $task;
				
			}
			echo  Response::TaskResponse(500,"WebService Errror",$data);	
			}
			
			function writefile($userKey,$requestKeyword)
			{
			
			$data ="\t #2 Task WebService \tuserKey: ".$userKey."\trequestKeyword: ".$requestKeyword;
			Logfile::writelog($data);
			
			}