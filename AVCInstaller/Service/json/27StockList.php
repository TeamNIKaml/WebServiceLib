<?php
	require_once 'LogFile.php';
	
		
		if(isset($_POST['userKey'])||isset($_POST['requestKeyword']))
		{	
			writefile($_POST['userKey'],$_POST['requestKeyword'],$_POST['project_id']);	
			
			echo '{"status":200,"status_message":"Sucess",  "StockList":[{"productId":"1","productName":"Bulb",  "quantity":5}]} ';
		}
		else
		{
			writefile("invalid","invalid,","invalid");
			
			echo '{"status":500,"status_message":"Webservice Error",  "StockList":[{"productId":"1","productName":"Bulb",  "quantity":5}]} ';
		}
		
		function writefile($userKey,$requestKeyword,$project_id)
		{
			
			$data ="\t #12 Cancel task Webservice \tuserKey:".$userKey."\trequestKeyword :".$requestKeyword."\t project_id : ".$project_id;
			Logfile::writelog($data);
			
		}


