<?php
	require_once 'LogFile.php';
	
		if(isset($_POST['userKey'])||isset($_POST['requestKeyword']))	
			{	
				writefile($_POST['userKey'],$_POST['requestKeyword']);
				
				echo '{"status":200,"status_message":"Success",
				"planningList":[{"projectId":"1","siteno":"123","siteName":"kochi",
				"projectName":"Avc","postcode":"683513"}]} ';

			}
		else{
				
				writefile("Invalid","Invalid");
				
				echo '{"status":500,"status_message":"Webservice Error",
				"planningList":[{"projectId":"1","siteno":"123","siteName":"kochi",
				"projectName":"Avc","postcode":"683513"}]} ';
			}
			
			function writefile($userKey,$requestKeyword)
			{
			
				$data ="\t #4 Work Require Planning WebService \tuserKey:".$userKey."\trequestKeyword :".$requestKeyword;
				Logfile::writelog($data);
			
			}
