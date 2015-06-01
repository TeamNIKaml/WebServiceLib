package com.teamNikaml.webservicelib.model;

public class Constant {
	
	private static final String HOST_NAME_HOME ="http://192.168.1.102:8080/AVCInstaller/Service/json/";
	private static final String HOST_NAME_OFFICE ="http://192.168.1.39:8080/AVCInstaller/Service/json/";
	private static final String HOST = HOST_NAME_OFFICE;
	//private static final String HOST_NAME = HOST_NAME_HOME;
	
	
	/*LOGIN_URL*/
	public static final String LOGIN_URL = HOST+"1LoginService.php";
	/* TASK_URL */
	public static final String TASK_URL = HOST+"2TaskWebService.php";	
	/* TASK_DETAILS_URL */
	public static final String TASK_DETAILS_URL = HOST+"3TaskDetailsWebservice.php";
	

}
