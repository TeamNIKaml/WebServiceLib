<?php
	require_once 'LogFile.php';
	
		if(isset($_POST['userKey'])||isset($_POST['requestKeyword']))	
			{	
				writefile($_POST['userKey'],$_POST['requestKeyword']);
				
					echo '{"status":200,"status_message":"Sucess",  "RoomReviewList":[{"projectId":"1", "projectName":"Avc","postcode":"683513",
					"asbestosRegisterStatus":"Yes","asbestosRegisterSigned":"Yes","siteNo":"#123456","siteName":"kochi"}]} ';

			}
		else{
				
				writefile("Invalid","Invalid");
				
				echo '{"status":500,"status_message":"Webservice Error",  "RoomReviewList":[{"projectId":"1", "projectName":"Avc","postcode":"683513",
				"asbestosRegisterStatus":"Yes","asbestosRegisterSigned":"Yes","siteNo":"#123456","siteName":"kochi"}]} ';

			}
			
			function writefile($userKey,$requestKeyword)
			{
			
				$data ="\t #16 RoomReviewList  WebService \tuserKey:".$userKey."\trequestKeyword :".$requestKeyword;
				Logfile::writelog($data);
			
			}


