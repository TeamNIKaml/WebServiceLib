package com.teamNikaml.webservicelib.activity;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.teamNikaml.webservicelib.model.Constant;
import com.teamNikaml.webservicelib.model.ParameterMapModel;
import com.teamNikaml.webservicelib.responseModel.LoginResponseModel;
import com.teamNikaml.webservicelib.responseModel.TaskResponseModel;
import com.teamNikaml.webservicelib.webservice.CallWebservice;

public class MainActivity extends Activity {

	private Map<String, String> loginMap = new HashMap<String, String>();

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
		// LoginResponseModel login = new LoginResponseModel();
		// mapModel.setLoginMap();
		// CallWebservice callWebservice = new
		// CallWebservice(getApplicationContext(), Constant.LOGIN_URL,
		// mapModel.getLoginMap(), login);
		// callWebservice.getService();

		/* task */
		 TaskResponseModel taskResponseModel = new TaskResponseModel();
		 CallWebservice callWebservice = new CallWebservice(getApplicationContext(), Constant.TASK_URL,
				 mapModel.getTaskMap(), taskResponseModel);
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
