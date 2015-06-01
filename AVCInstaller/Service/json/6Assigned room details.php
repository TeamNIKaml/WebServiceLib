<?php
	require_once 'LogFile.php';
	
		if(isset($_POST['userKey'])||isset($_POST['requestKeyword']))	
		{	
			writefile($_POST['userKey'],$_POST['requestKeyword'],$_POST['project_id'],$_POST['room_id']);	

			echo '{"status":200,"status_message":"Sucess",
			"floor":[{"rooms":[{"roomId":"#1234","roominfo":[{"heightOfRoom":"11",
			"magicPlanImageUrl":"image url",
			"accessRequired":[{"tools":"ladder"}]}]}]}]} ';

		}
		else
		{
				
				writefile("Invalid","Invalid","invalid","invalid");
				echo '{"status":500,"status_message":"WebService Errror",
			"floor":[{"rooms":[{"roomId":"#1234","roominfo":[{"heightOfRoom":"11",
			"magicPlanImageUrl":"image url",
			"accessRequired":[{"tools":"ladder"}]}]}]}]} ';
		}

		function writefile($userKey,$requestKeyword,$project_id,$room_id)
		{
			
			$data ="\t #6 Assigned Room Details WebService \tuserKey:".$userKey."\trequestKeyword :".$requestKeyword."\t project_id".$project_id."\t room_id".$room_id;
			Logfile::writelog($data);
			
		}