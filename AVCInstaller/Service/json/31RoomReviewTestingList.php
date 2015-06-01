<?php
	require_once 'LogFile.php';
	
		if(isset($_POST['userKey'])||isset($_POST['requestKeyword']))	
			{	
				writefile($_POST['userKey'],$_POST['requestKeyword']);
				
				echo '{"status":200,"status_message":"Sucess","RoomReviewTestingList":[{"projectId":"1","siteno":"123", "projectName":"Avc","postcode":"683513"}]} ';

			}
		else{
				
				writefile("Invalid","Invalid");
				
				echo '{"status":500,"status_message":"Webservice Error","RoomReviewTestingList":[{"projectId":"1","siteno":"123", "projectName":"Avc","postcode":"683513"}]} ';
			}
			
			function writefile($userKey,$requestKeyword)
			{
			
				$data ="\t #31 RoomReviewTestingList WebService \tuserKey:".$userKey."\trequestKeyword :".$requestKeyword;
				Logfile::writelog($data);
			
			}




