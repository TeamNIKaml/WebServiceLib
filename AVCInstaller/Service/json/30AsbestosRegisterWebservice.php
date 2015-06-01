<?php
	require_once 'Response.php';
	require_once 'LogFile.php';
    $file_path = "uploads/AsbestosRegister/";
	
	
	if(isset($_POST['userkey'] ))	
	{	
			writefilepost($_POST['userkey'],$_POST['requestKeyword']);
	}
	else
	{
		writefilepost("Invalid userkey","invalid request key");
		
	}
	
	if(isset($_FILES['uploaded_file']['name']))
	{
		$file_path = $file_path . basename( $_FILES['uploaded_file']['name']);	
		
		if(move_uploaded_file($_FILES['uploaded_file']['tmp_name'], $file_path)) {
			
			writefile($file_path,"Sucess");
			echo Response::AsbestosRegisterResponse(200,"File is Sucessfully uploaded");	
		}
		else
		{
			writefile($file_path,"Failed");
			echo Response::AsbestosRegisterResponse(500,"Unable to complete the file upload");	
		}

	}	
	else
	{
		writefile($file_path,"Failed");
        echo Response::AsbestosRegisterResponse(500,"Unable to read from upladed file");	
    }
	
	
	function writefile($file_path,$status)
			{
			
				$data ="\t #30 AsbestosRegisterWebservice Fileupload"."\tFileName:".$file_path."\tStatus:".$status;
				Logfile::writelog($data);
			
			}
	function writefilepost($userkey,$requestKeyword)
			{
			
				$data ="\t #30 AsbestosRegisterWebservice Data"."\tUserkey:".$userkey."\t$requestKeyword :".$requestKeyword;
				Logfile::writelog($data);
			}

 ?>
