<?php
	require_once 'Response.php';
	require_once 'LogFile.php';
    $file_path = "uploads/";
	
	
	if(isset($_POST['userkey'] ))	
	{	
			writefilepost($_POST['userkey']);
	}
	else
	{
		writefilepost("Invalid userkey");
		
	}
	
	if(isset($_FILES['uploaded_file']['name']))
	{
		$file_path = $file_path . basename( $_FILES['uploaded_file']['name']);	
		
		if(move_uploaded_file($_FILES['uploaded_file']['tmp_name'], $file_path)) {
			
			writefile($file_path,"Sucess");
			echo Response::commonResponse(200,"File is Sucessfully uploaded");	
		}
		else
		{
			writefile($file_path,"Failed");
			echo Response::commonResponse(500,"Unable to complete the file upload");	
		}

	}	
	else
	{
		writefile($file_path,"Failed");
        echo Response::commonResponse(500,"Unable to read from upladed file");	
    }
	
	
	function writefile($file_path,$status)
			{
			
				$data ="\tFileUpload WebService"."\tFileName:".$file_path."\tStatus:".$status;
				Logfile::writelog($data);
			
			}
	function writefilepost($userkey)
			{
			
				$data ="\tFileUpload WebService"."\tUserkey:".$userkey;
				Logfile::writelog($data);
			}
			
			
			
	
	
	
 ?>
