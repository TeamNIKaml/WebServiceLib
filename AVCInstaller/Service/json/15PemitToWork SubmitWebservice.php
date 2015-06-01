<?php
	require_once 'Response.php';
	require_once 'LogFile.php';
  
	
	
	if(isset($_POST['userkey'] ))	
	{	



			writefilepost($_POST['userkey'],$_POST['requestKeyword'],$_POST['task_identification'],$_POST['other'],$_POST['task_classification']
			,$_POST['additional_precautions'],$_POST['duration'],$_POST['customer_name'],$_POST['customer_email'],$_POST['projectId']);
	}
	else
	{
		writefilepost("Invalid userkey","invalid request key","Invalid task_identification","Invalid other","Invalid task_classification",
		"Invalid additional_precautions","Invalid duration","Invalid customer_name","Invalid customer_email","Invalid projectId");
		
	}
	 $file_path = "uploads/PermitTowork/";
	if(isset($_FILES['customer_signature']['name']))
	{
	
		$folder ="customerSignature/";
		
		$file_path = $file_path .$folder. basename( $_FILES['customer_signature']['name']);	
		
		
		
		if(move_uploaded_file($_FILES['customer_signature']['tmp_name'], $file_path)) {
			
			writefile($file_path,"customer_signature Sucess");
			
		}
		else
		{
			writefile($file_path,"customer_signature inner Failed");
			
		}

	}	
	else
	{
		writefile($file_path,"customer_signature Failed");
        echo Response::AsbestosRegisterResponse(500,"Unable to customer_signature read from uploaded file");	
    }
	
	if(isset($_FILES['competent_person_signature']['name']))
	{
		$file_path = "uploads/PermitTowork/";
		$folder ="personSignature/";
		$file_path = $file_path.$folder.basename( $_FILES['competent_person_signature']['name']);	
		
		if(move_uploaded_file($_FILES['competent_person_signature']['tmp_name'], $file_path)) {
			
			writefile($file_path,"competent_person_signature Sucess");
			echo Response::AsbestosRegisterResponse(200,"File is Sucessfully uploaded");	
		}
		else
		{
			writefile($file_path,"competent_person_signature inner Failed");
			echo Response::AsbestosRegisterResponse(500,"Unable to complete the file upload");	
		}

	}	
	else
	{
		writefile($file_path,"competent_person_signature outer Failed");
        echo Response::AsbestosRegisterResponse(500,"Unable to read competent_person_signature from upladed file");	
    }
	
		
	
	function writefile($file_path,$status)
			{
			
				$data ="\t 15 PemitToWork SubmitWebservice fileUpload"."\tFileName: ".$file_path."\tStatus:".$status;
				Logfile::writelog($data);
			
			}
			
	function writefilepost($userkey,$requestKeyword,$task_identification,$other,$task_classification,$additional_precautions,$duration,$customer_name,$customer_email,$projectId)
			{
			
				$data ="\t #15 PemitToWork SubmitWebservice data"."\tUserkey:".$userkey."\t requestKeyword :".$requestKeyword."\t task_identification :".$task_identification."\t other :".$other."\t task_classification :".$task_classification."\t additional_precautions :".$additional_precautions."\t duration :".$duration."\t customer_name :".$customer_name."\t customer_email :".$customer_email."\t projectId :".$projectId;
				Logfile::writelog($data);
			}

 ?>
