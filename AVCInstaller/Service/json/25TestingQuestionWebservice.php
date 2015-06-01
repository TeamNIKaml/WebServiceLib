<?php
		
		require_once 'Response.php';
		require_once 'LogFile.php';
		require_once 'TestingQuestionModel.php';
		
		

			if(isset($_POST['userKey']))	
			{	
			writefile($_POST['userKey'],$_POST['requestKeyword']);

			$data = array();
			
			$id = array("1", "2","3","4");
			$name = array("Has every circuit worked on been tested", "Has each area been cleaned and cleared of waste","Has a site walk around been completed with customer","Is the customer satisfied with the installation");
			
			
			for($i=0;$i<4;$i++)
			{
				$testingQuestionModel = new TestingQuestionModel($id[$i],$name[$i]);
				$data[$i] = $testingQuestionModel;
				
			}
			
			
			echo Response::TestingQuestionResponse(200,"Sucess",$data);	
			}
			else
			{
			writefile("Invalid","Invalid");
			
			//$data[0] = "invalid";
			$data = array();
			
		
			
			$id = array("1", "2","3","4");
			$name = array("Has every circuit worked on been tested", "Has each area been cleaned and cleared of waste","Has a site walk around been completed with customer","Is the customer satisfied with the installation");
			
			
			for($i=0;$i<4;$i++)
			{
				$testingQuestionModel = new TestingQuestionModel($id[$i],$name[$i]);
				$data[$i] = $testingQuestionModel;
				
			}
			echo  Response::TestingQuestionResponse(500,"WebService Errror",$data);	
			}
			
			function writefile($userKey,$requestKeyword)
			{
			
			$data ="\t #25 TestingQuestionWebservice \tuserKey: ".$userKey."\trequestKeyword: ".$requestKeyword;
			Logfile::writelog($data);
			
			}