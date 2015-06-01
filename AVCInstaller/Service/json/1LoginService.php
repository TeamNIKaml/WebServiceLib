<?php
		
		require_once 'Response.php';
		require_once 'LogFile.php';
		
		

			if(isset($_POST['emailId'])||isset($_POST['password']))	
			{	
			writefile($_POST['emailId'],$_POST['password'],$_POST['requestKeyword']);

			$data[0] = md5("userkey;");
			$data[1] = "Project Lead";
			$data[2] = 5;
			
			
			echo Response::loginResponse(200,"Sucess",$data);	
			}
			else
			{
			writefile("Invalid","Invalid","invalid","invalid");
			
			$data[0] = "invalid";
			$data[1] = "invalid";
			$data[2] = "invalid";
						
		
			
			echo Response::loginResponse(501,"Invalid username or password",$data);	
			}
			
			function writefile($user,$password,$requestKeyword)
			{
			
			$data ="\t #1 Login WebService \tEmailid:".$user."\tPASSWORD:".$password."\trequestKeyword".$requestKeyword;
			Logfile::writelog($data);
			
			}