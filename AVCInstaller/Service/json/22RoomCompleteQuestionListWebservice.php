<?php
		
		require_once 'Response.php';
		require_once 'LogFile.php';
		require_once 'RoomCompleteQuestionModel.php';
		
		

			if(isset($_POST['userKey']))	
			{	
			writefile($_POST['userKey'],$_POST['requestKeyword']);

			$data = array();
			
			$id = array("1", "2");
			$name = array("Has the installation been completed as per the work instructions", "Has the area been cleaned and cleared of waste");
			
			
			for($i=0;$i<2;$i++)
			{
				$roomCompleteQuestionModel = new RoomCompleteQuestionModel($id[$i],$name[$i]);
				$data[$i] = $roomCompleteQuestionModel;
				
			}
			
			
			echo Response::RoomCompleteQuestionResponse(200,"Sucess",$data);	
			}
			else
			{
			writefile("Invalid","Invalid");
			
			//$data[0] = "invalid";
			$data = array();
			
		
			
			$id = array("1", "2");
			$name = array("Has the installation been completed as per the work instructions", "Has the area been cleaned and cleared of waste");
			
			
			for($i=0;$i<2;$i++)
			{
				$roomCompleteQuestionModel = new RoomCompleteQuestionModel($id[$i],$name[$i]);
				$data[$i] = $roomCompleteQuestionModel;
				
			}
			echo  Response::RoomCompleteQuestionResponse(500,"WebService Errror",$data);	
			}
			
			function writefile($userKey,$requestKeyword)
			{
			
			$data ="\t #22 Room Complete Question WebService \tuserKey: ".$userKey."\trequestKeyword: ".$requestKeyword;
			Logfile::writelog($data);
			
			}