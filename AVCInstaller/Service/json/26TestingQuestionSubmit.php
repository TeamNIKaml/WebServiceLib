<?php
	require_once 'LogFile.php';
	
	//not completed array processing is requiried	
		if(isset($_POST['userKey'])||isset($_POST['requestKeyword']))
		{	
	
	$question ="{";
				foreach( $_POST as &$teammembers ) 
				{
					if( is_array( $teammembers ) ) 
					{
							
							for($i=0;$i<sizeof($teammembers);$i++)
							{
								if($i==0)
								$question .= $teammembers[$i];
							else
							$question .= ",".$teammembers[$i];
							}
							$question .= "}";
									
					} 
				}	
				
				
				$stock ="{";
				foreach( $_POST as &$teammembers ) 
				{
					if( is_array( $teammembers ) ) 
					{
							
							for($i=0;$i<sizeof($teammembers);$i++)
							{
								if($i==0)
								$stock .= $teammembers[$i];
							else
							$stock .= ",".$teammembers[$i];
							}
							$stock .= "}";
									
					} 
				}
	
	
	
	
	
			writefile($_POST['userKey'],$_POST['requestKeyword'],$question,$stock);	
			
			echo '{"status":200,"status_message":"Sucess"} ';
		}
		else
		{
				$cars = array("Volvo", "BMW", "Toyota");
			
			$question ="{";
			for($i=0;$i<sizeof($cars);$i++)
			{
				if($i==0)
				$question .= $cars[$i];
			else
			$question .= ",".$cars[$i];
			}
			$question .= "}";
			
			
			
			$stock ="{";
			for($i=0;$i<sizeof($cars);$i++)
			{
				if($i==0)
				$stock .= $cars[$i];
			else
			$stock .= ",".$cars[$i];
			}
			$stock .= "}";
			
			
			
			
			writefile("invalid","invalid",$question,$stock);
			
			echo '{"status":500,"status_message":"Webservice Error"} ';
		}
		
		function writefile($userKey,$requestKeyword,$question,$stock)
		{
			
			$data ="\t #26 TestingQuestionSubmit Webservice \tuserKey:".$userKey."\trequestKeyword :".$requestKeyword.
					"\t question : ".$question."\t stock".$stock;
			Logfile::writelog($data);
			
		}