<?php
	require_once 'LogFile.php';
	
		if(isset($_POST['userKey'])||isset($_POST['requestKeyword']))	
		{	
				writefile($_POST['userKey'],$_POST['requestKeyword'],$_POST['room_id']);	
				echo'{"status":500,"status_message":"Sucess",
				"AssignedInstallersList":[{"taskId":"1","userId":"#1234",
				"userName":"Sasi","priority":1,"comments":"urgent",
				"designation":"Mate","startDate":"21-3-2014","EndDate":"31-3-2014"}]}';

		}
		else
		{
				
				writefile("Invalid","invalid","invalid");
				echo'{"status":500,"status_message":"Sucess",
				"AssignedInstallersList":[{"taskId":"1","userId":"#1234",
				"userName":"Sasi","priority":1,"comments":"urgent",
				"designation":"Mate","startDate":"21-3-2014","EndDate":"31-3-2014"}]}';
				
		}

		function writefile($userKey,$requestKeyword,$room_id)
		{
			
			$data ="\t #10 Assigned installers list WebService \tuserKey:".$userKey."\trequestKeyword :".$requestKeyword."\t room_id".$room_id;
			Logfile::writelog($data);
			
		}