<?php
	require_once 'LogFile.php';
	
	
	
		if(isset($_POST['userKey'])||isset($_POST['requestKeyword'])) 
		{	
			writefile($_POST['userKey'],$_POST['requestKeyword'],$_POST['task_id'],$_POST['room_id']);	
			
			echo '{"status":200,"status_message":"Sucess"} ';
		}
		else
		{
			writefile("invalid","invalid,","invalid","invalid");
			
			echo '{"status":500,"status_message":"Webservice Error"} ';
		}
		
		function writefile($userKey,$requestKeyword,$task_id,$room_id)
		{
			
			$data ="\t #18 AcceptRoomReview Webservice \tuserKey:".$userKey."\trequestKeyword :".$requestKeyword."\t task_id : ".$task_id."\troom_id: ".$room_id;
			Logfile::writelog($data);
			
		}