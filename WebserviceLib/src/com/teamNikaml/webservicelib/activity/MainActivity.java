package com.teamNikaml.webservicelib.activity;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;

import com.teamNikaml.webservicelib.model.Constant;
import com.teamNikaml.webservicelib.model.Dictionary;
import com.teamNikaml.webservicelib.model.ParameterMapModel;
import com.teamNikaml.webservicelib.responseModel.AsbestosRegister_30;
import com.teamNikaml.webservicelib.responseModel.AssignedRoomsubmit_8;
import com.teamNikaml.webservicelib.responseModel.LoginResponseModel_1;
import com.teamNikaml.webservicelib.responseModel.PermitToWorkSubmit_15;
import com.teamNikaml.webservicelib.responseModel.TaskDetailsResponseModel_3;
import com.teamNikaml.webservicelib.responseModel.TaskResponseModel_2;
import com.teamNikaml.webservicelib.webservice.CallWebservice;
import com.teamNikaml.webservicelib.webservice.FileuploadWebService;

public class MainActivity extends Activity {
	
	


	
	 TaskResponseModel_2 taskResponseModel = new TaskResponseModel_2();
	 
	 LoginResponseModel_1 login = new LoginResponseModel_1();
	  
	 TaskDetailsResponseModel_3 taskDetailsResponseModel = new TaskDetailsResponseModel_3();
	 
	 AsbestosRegister_30 asbestosRegisterResponseModel = new AsbestosRegister_30();
	 PermitToWorkSubmit_15 permitToWorkSubmit = new PermitToWorkSubmit_15();
	 
	 AssignedRoomsubmit_8 assignedRoomsubmit = new AssignedRoomsubmit_8();
	 
	 List<Dictionary> parameterList = new ArrayList<Dictionary>();
	
	 
	
	 
	private final Handler myHandler = new Handler() {
		public void handleMessage(Message msg) {
			
			System.out.println("Myhandler#:"+assignedRoomsubmit);
		}
	};
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setData();

	
	
	

	}

	private void setData() {
		// TODO Auto-generated method stub
		
		ParameterMapModel mapModel = new ParameterMapModel();

		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		String customerSignaturePath=createImageFile("CustomerSignature", getApplicationContext(), bitmap);
		String competentPersonSignaturePath=createImageFile("competentPersonSignature", getApplicationContext(), bitmap);
		
		
		String asbestosRegisterPath=createImageFile("AsbestosRegisterSignature", getApplicationContext(), bitmap);
		
		
	
		
		
		
		
	

	
		
	
		parameterList.add(new Dictionary("userKey","nik@6bc459e0cf4082e7f49a56ebea0ae2d7d"));
		parameterList.add(new Dictionary("requestKeyword","Assigned Room submit"));
		parameterList.add(new Dictionary("project_id", "#234"));	
		parameterList.add(new Dictionary("task_title", "Mywork"));	
		parameterList.add(new Dictionary("room_id", "#21"));
		parameterList.add(new Dictionary("priority", "1"));
		parameterList.add(new Dictionary("start_date", "23-6-2015"));	
		parameterList.add(new Dictionary("end_date", "25-8-2015"));
		parameterList.add(new Dictionary("comment", "new"));
		parameterList.add(new Dictionary("teammember[]", "ronaldo"));		
		parameterList.add(new Dictionary("teammember[]", "messi"));
		parameterList.add(new Dictionary("teammember[]", "naymer"));
		parameterList.add(new Dictionary("teammember[]", "benzama"));
		
			
		CallWebservice callWebservice = new CallWebservice(Constant.ASSIGNED_ROOM_SUBMIT_URL, assignedRoomsubmit, parameterList);
			CallWebservice.setHandler(myHandler);
			callWebservice.getService();	
		
		
		
		
		
		/*FileuploadWebService fileuploadWebService = new FileuploadWebService(Constant.ASSIGNED_ROOM_SUBMIT_URL, parameterList, assignedRoomsubmit);
		FileuploadWebService.setHandler(myHandler);
		fileuploadWebService.getService();*/
		
		

	
	

		
		
		
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
	
	public  String createImageFile(String imageFileName,
			Context context,Bitmap tempSignature ) {
		int BUFFER_SIZE = 1024 * 8;
		File file;
		//tempSignature = bitmap;
		file = new File(context.getFilesDir() + "/" + imageFileName + ".jpg");
		try {
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			final BufferedOutputStream bos = new BufferedOutputStream(fos,
					BUFFER_SIZE);
			tempSignature.compress(CompressFormat.JPEG, 100, bos);
			bos.flush();
			bos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

		}
		System.out.println("path : " + file.getAbsolutePath());

		

		return file.getAbsolutePath();
	}
	
}
