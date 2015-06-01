<?php
	require_once 'LogFile.php';
	
	//incomplete post parameter array need to add;
	
		if(isset($_POST['userKey'])||isset($_POST['requestKeyword'])) 			
		{	
	
				$assigned_persons ="{";
				foreach( $_POST as &$teammembers ) 
				{
					if( is_array( $teammembers ) ) 
					{
							
							for($i=0;$i<sizeof($teammembers);$i++)
							{
								if($i==0)
								$assigned_persons .= $teammembers[$i];
							else
							$assigned_persons .= ",".$teammembers[$i];
							}
							$assigned_persons .= "}";
									
					} 
				}		
			writefile($_POST['userKey'],$_POST['requestKeyword'],$_POST['project_id'],$_POST['room_id'],$_POST['task_title'],$_POST['priority'],$_POST['start_date'],
								$_POST['end_date'],$_POST['comment'],$assigned_persons);	
			
			echo '{"status":200,"status_message":"Sucess"} ';
		}
		else
		{
			
			$cars = array("Volvo", "BMW", "Toyota");
			
			$data ="{";
			for($i=0;$i<sizeof($cars);$i++)
			{
				if($i==0)
				$data .= $cars[$i];
			else
			$data .= ",".$cars[$i];
			}
			$data .= "}";
			
			
			
			writefile("invalid","invalid,","invalid","invalid","invalid","invalid,","invalid","invalid","invalid",$data);
			
			echo '{"status":500,"status_message":"Webservice Error"} ';
		}
		
		function writefile($userKey,$requestKeyword,$project_id,$room_id,$task_title,$priority,$start_date,$end_date,$comment,$assigned_persons)
		{
			
			$data ="\t #8 Assigned Room Submit WebService \tuserKey:".$userKey."\t requestKeyword :".$requestKeyword."\t project_id:".$project_id.
			"\t room_id:".$room_id."\t task_title:".$task_title."\t priority:".$priority."\t start_date: ".$start_date."\t end_date: ".$end_date.
			"\t comment : ".$comment."\t assigned_persons : ".$assigned_persons;
			Logfile::writelog($data);
			
		}


