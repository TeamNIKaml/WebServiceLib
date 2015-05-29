package com.teamNikaml.webservicelib.activity;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.teamNikaml.webservicelib.model.Constant;
import com.teamNikaml.webservicelib.model.Login;
import com.teamNikaml.webservicelib.webservice.CallWebservice;

public class MainActivity extends Activity {
	
	
	//params1.add(new BasicNameValuePair("emailId", user.getEmailId()));
	//params1.add(new BasicNameValuePair("password", user.getPassword()));
	//params1.add(new BasicNameValuePair("userType", user.getDesignation()));
	//params1.add(new BasicNameValuePair("requestKeyword", "Login"));

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Login login = new Login();
		
		Map<String, String> parametersMap = new HashMap<String, String>();
		parametersMap.put("emailId", "abc@hm.cc");
		parametersMap.put("password", "loginpassword");
		parametersMap.put("requestKeyword", "Login");
		
		CallWebservice callWebservice = new CallWebservice(getApplicationContext(), Constant.LOGIN_URL, parametersMap, login);
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
