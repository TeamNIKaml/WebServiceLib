<?php
	require_once 'LogFile.php';
	
		if(isset($_POST['userKey'])||isset($_POST['requestKeyword']))	
			{	
				writefile($_POST['userKey'],$_POST['requestKeyword'],$_POST['project_id']);
				
				echo '{"status":200,"status_message":"Success","floor":[{"rooms":[{"taskId":"#123","roomID":"#123",
				"roominfo":[{"heightOfRoom":"11","magicPlanImageUrl":"image url","productList":[{"productName":"Bulb","quantity":6}]}]}]}],
				"HSIssue":[{"identifiedHazard":"Hazzard1","classificationCode":"code1","riskLevel":"high","riskManagement":"risk1"}],
				"DynamicRiskAssesment":[{"identifiedHazard":"Hazzard1","classificationCode":"code1","riskLevel":"high","riskManagement":"risk1",
				"comments":"careful"}]} ';

			}
		else{
				
				writefile("Invalid","Invalid","invalid");
				
				echo '{"status":500,"status_message":"WebService Errror","floor":[{"rooms":[{"taskId":"#123","roomID":"#123",
				"roominfo":[{"heightOfRoom":"11","magicPlanImageUrl":"image url","productList":[{"productName":"Bulb","quantity":6}]}]}]}],
				"HSIssue":[{"identifiedHazard":"Hazzard1","classificationCode":"code1","riskLevel":"high","riskManagement":"risk1"}],
				"DynamicRiskAssesment":[{"identifiedHazard":"Hazzard1","classificationCode":"code1","riskLevel":"high","riskManagement":"risk1",
				"comments":"careful"}]} ';
			}
			
			function writefile($userKey,$requestKeyword,$project_id)
			{
			
				$data ="\t #20 InstallationStartList WebService \tuserKey:".$userKey."\trequestKeyword :".$requestKeyword."\tproject_id : ".$project_id;
				Logfile::writelog($data);
			
			}





