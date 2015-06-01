<?php
	require_once 'LogFile.php';  
	
		if(isset($_POST['userKey'])||isset($_POST['requestKeyword']))	
			{	
				writefile($_POST['userKey'],$_POST['requestKeyword'],$_POST['project_id']);
				
				echo '{"status":200,"status_message":"Sucess",
				"PermitToWorkDetails":[{"CustomerName":"Raju","email":"abc@gg.cc", "duration":"2 Months"}]} ';

			}
		else{
				
				writefile("Invalid","Invalid","invalid");
				
				echo '{"status":200,"status_message":"Sucess",
				"PermitToWorkDetails":[{"CustomerName":"Raju","email":"abc@gg.cc", "duration":"2 Months"}]} ';
			}
			
			function writefile($userKey,$requestKeyword,$project_id)
			{
			
				$data ="\t #14 PermitToWorkDetails  WebService \tuserKey:".$userKey."\trequestKeyword :".$requestKeyword."\tproject_id:".$project_id;
				Logfile::writelog($data);
			
			}





