<?php


class Logfile 
{
	public static function writelog($data)
	{		
		$logFileName = "AVCInstaller.log";	
		date_default_timezone_set("Asia/Calcutta"); 		
		$myfile = fopen($logFileName, "a") or die("Unable to open file!");
		$txt ="\n".date('Y-m-d H:i:s').$data;
		fwrite($myfile, $txt);
		fclose($myfile);
	}	
}




?>