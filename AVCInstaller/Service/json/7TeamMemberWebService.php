<?php
		
		require_once 'Response.php';
		require_once 'LogFile.php';
		require_once 'TeamMemberModel.php';
		
		

			if(isset($_POST['userKey']))	
			{	
			writefile($_POST['userKey'],$_POST['requestKeyword']);

			$data = array();
			
			$id = array("1", "2", "3", "4");
			$name = array("Ronaldo", "Messi", "Kane", "DiMariya");
			$designation = array("Project Lead", "Electrician", "Electrician", "Mate");
			
			
			for($i=0;$i<4;$i++)
			{
				$teamMemberModel = new TeamMemberModel($id[$i],$name[$i],$designation[$i]);
				$data[$i] = $teamMemberModel;
				
			}
			
			
			echo Response::TeamMemberResponse(200,"Sucess",$data);	
			}
			else
			{
			writefile("Invalid","Invalid");
			
			//$data[0] = "invalid";
			$data = array();
			
		
			
			$id = array("1", "2", "3", "4");
			$name = array("Ronaldo", "Messi", "Kane", "DiMariya");
			$designation = array("Project Lead", "Electrician", "Electrician", "Mate");
			
			
			for($i=0;$i<4;$i++)
			{
				$teamMemberModel = new TeamMemberModel($id[$i],$name[$i],$designation[$i]);
				$data[$i] = $teamMemberModel;
				
			}
			echo  Response::TeamMemberResponse(500,"WebService Errror",$data);	
			}
			
			function writefile($userKey,$requestKeyword)
			{
			
			$data ="\t #7 TeamMember WebService \tuserKey: ".$userKey."\trequestKeyword: ".$requestKeyword;
			Logfile::writelog($data);
			
			}