<?php
	require_once 'LogFile.php';
	
		if(isset($_POST['userKey'])||isset($_POST['requestKeyword']))	
			{	
				
				writefile($_POST['userKey'],$_POST['requestKeyword'],$_POST['project_id']);				
				echo'	{"status":500,"status_message":"Unable to read from upladed file",
				"AssignedRoomList":[{"taskId":"1","floor":"1",
				"roomid":"#1234","roomName":"My room","count":"Electrician 3 Mate 2","startDate":"21-3-2014","EndDate":"31-3-2014"}]} ';
			
			}	
			else{
				
				writefile("Invalid","Invalid","invalid");
				
				echo'	{"status":500,"status_message":"Unable to read from upladed file",
				"AssignedRoomList":[{"taskId":"1","floor":"1",
				"roomid":"#1234","roomName":"My room","count":"Electrician 3 Mate 2","startDate":"21-3-2014","EndDate":"31-3-2014"}]} ';
			}
			
			function writefile($userKey,$requestKeyword,$project_id)
			{
			
				$data ="\t #5 AssignedRoomList WebService \tuserKey:".$userKey."\trequestKeyword :".$requestKeyword."\t project_id".$project_id;
				Logfile::writelog($data);
			
			}