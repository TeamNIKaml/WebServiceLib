package com.teamNikaml.webservicelib.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;

import com.teamNikaml.webservicelib.model.Constant;
import com.teamNikaml.webservicelib.model.ParameterMapModel;
import com.teamNikaml.webservicelib.responseModel.LoginResponseModel_1;
import com.teamNikaml.webservicelib.responseModel.TaskDetailsResponseModel_3;
import com.teamNikaml.webservicelib.responseModel.TaskResponseModel_2;
import com.teamNikaml.webservicelib.webservice.CallWebservice;

public class MainActivity extends Activity {
	
	 TaskResponseModel_2 taskResponseModel = new TaskResponseModel_2();
	 
	 LoginResponseModel_1 login = new LoginResponseModel_1();
	  
	 TaskDetailsResponseModel_3 taskDetailsResponseModel = new TaskDetailsResponseModel_3();
	
	private final Handler myHandler = new Handler() {
		public void handleMessage(Message msg) {
			
			System.out.println("Myhandler#:"+taskDetailsResponseModel);
		}
	};
	

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// params1.add(new BasicNameValuePair("emailId", user.getEmailId()));
		// params1.add(new BasicNameValuePair("password", user.getPassword()));
		// params1.add(new BasicNameValuePair("userType",
		// user.getDesignation()));
		// /.add(new BasicNameValuePair("requestKeyword", "Login"));
		
		
		
		

		ParameterMapModel mapModel = new ParameterMapModel();

	

		/* login */
		// 
		// mapModel.setLoginMap();
		// CallWebservice callWebservice = new
		// CallWebservice(getApplicationContext(), Constant.LOGIN_URL,
		// mapModel.getLoginMap(), login);
		// CallWebservice.setHandler(myHandler);
		// callWebservice.getService();

		/* task */
		
		
		 /* mapModel.setTaskMap();
		 CallWebservice callWebservice = new CallWebservice(getApplicationContext(), Constant.TASK_URL,
				 mapModel.getTaskMap(), taskResponseModel);
		 CallWebservice.setHandler(myHandler);
		 callWebservice.getService();*/
		 
		 
		 /*Task Details*/
		
		 mapModel.setTaskDetailsMap();
		 CallWebservice callWebservice = new CallWebservice(getApplicationContext(), Constant.TASK_DETAILS_URL,
				 mapModel.getTaskDetailsMap(), taskDetailsResponseModel);
		 CallWebservice.setHandler(myHandler);
		 callWebservice.getService();
		 

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
