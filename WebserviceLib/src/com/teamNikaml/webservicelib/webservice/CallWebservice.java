package com.teamNikaml.webservicelib.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import com.teamNikaml.webservicelib.model.ReflectionModel;
import com.teamNikaml.webservicelib.model.TaskList;

public class CallWebservice {

	private static InputStream is = null;

	private String URL;
	private Map<String, String> parametersMap;
	private Object classObject;
	
	private static Handler myHandler;
	
	
	public static void setHandler(Handler h) {
		myHandler = h;
	}

	private void callHandler() {
		
	
		
		if (myHandler != null) {
			myHandler.sendEmptyMessage(1);
		}
	}
	
	

	public CallWebservice(Context context, String uRL,
			Map<String, String> parametersMap, Object classObject) {
		super();
		// this.context = context;
		URL = uRL;
		this.parametersMap = parametersMap;
		this.classObject = classObject;
	}

	public void getService() {

		new WebserviceAsyncTask().execute("webservice");

	}

	@SuppressLint("DefaultLocale")
	private class WebserviceAsyncTask extends
			AsyncTask<String, Integer, String> {
		
		private void setData(JSONObject json_data,String fieldName,  Object classData) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JSONException, NoSuchMethodException
		{
			String setterName = null;
			setterName = "set"
					+ fieldName.substring(0, 1)
							.toUpperCase()
					+ fieldName.substring(1);
			// fields[j].set
			Method set = classData.getClass().getMethod(
					setterName, setterName.getClass());
			set.invoke(classData,
					json_data.getString(fieldName));
			
			
			
		}
		
		
	
		
		
		

	
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);

			JSONObject json_data;
			ReflectionModel model = new ReflectionModel();

			model.setClassName(classObject.getClass());

			model.getFieldName();

			List<String> fieldList = model.getFieldNameList();
			List<String> listObjectArrayList = model.getListObjectArrayList();
			List<Object> objectList = new ArrayList<Object>();
			
			JSONArray jsonArray;
			Class<?>  listGenericClass = null;
		

			try {
				json_data = new JSONObject(result);

				for (int i = 0; i < json_data.length(); i++) {

					
					for (int j = 0; j < fieldList.size(); j++) {
					
						setData(json_data,fieldList.get(j),classObject);
						
						

					}
					
				}
					
				
					
					for(int k=0;k<listObjectArrayList.size();k++)
					{
						jsonArray = json_data.getJSONArray(listObjectArrayList.get(k));
						JSONObject jsonObject;
						
						for (int i = 0; i < jsonArray.length(); i++) {
							
							jsonObject = jsonArray.getJSONObject(i);
						
						
						Field field = classObject.getClass().getDeclaredField(listObjectArrayList.get(k));
						
					
						
						listGenericClass  = model.getClassName(field);
						 
						
						 
						 Object myjsonObject = listGenericClass.newInstance();
						 
					
						 ReflectionModel model2 = new ReflectionModel();
						 
						 model2.setClassName(listGenericClass);
						 
						 model2.getFieldName();
						 
						 
						 List<String> fieldList1 = model2.getFieldNameList();
				
							for (int j = 0; j < fieldList1.size(); j++) {
								
														
								setData(jsonObject,fieldList1.get(j),myjsonObject);
						 
						
							}
						 
						 
							 objectList.add(myjsonObject);
						}	
						
						List<TaskList> taskLists = new ArrayList<TaskList>();
						for(int i=0;i<objectList.size();i++)
						{
						TaskList task =(TaskList)objectList.get(i);
						taskLists.add(task);
						}
					//	System.out.println(taskLists);
						//taskLists = objectList;
					//	taskLists.getClass().g
						String setterName = "set"
								+ listObjectArrayList.get(k).substring(0, 1)
										.toUpperCase()
								+ listObjectArrayList.get(k).substring(1);
						
					//	System.out.println(setterName);
						
						Method[] method = classObject.getClass().getMethods();
								
							
						for(int i=0;i<method.length;i++)
						{
							
							String methodName = method[i].getName();
							if(methodName.equals(setterName))
							{
								System.out.println("indide : "+method[i].getName()+" Settername: "+setterName);
								method[i].invoke(classObject,taskLists);
								
								break;
							}
						}
						
						
					//	TaskResponseModel task =(TaskResponseModel)classObject;
				
						
					
								
								
								
								
								
								
								
								
						
					}
					
					

				

			} catch (final JSONException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//	System.out.println(classObject);
		//	System.out.println(objectList.size());
			callHandler();
		}

		@Override
		@SuppressWarnings("rawtypes")
		protected String doInBackground(String... params) {

			String json = "";
			final List<BasicNameValuePair> params1 = new ArrayList<BasicNameValuePair>();

			Iterator entries = parametersMap.entrySet().iterator();
			while (entries.hasNext()) {

				Map.Entry entry = (Map.Entry) entries.next();
				String key = (String) entry.getKey();
				String value = (String) entry.getValue();
				System.out.println("Key = " + key + ", Value = " + value);

				params1.add(new BasicNameValuePair(key, value));

			}

			try {

				HttpPost httpPost = null;
				final DefaultHttpClient httpClient = new DefaultHttpClient();
				httpPost = new HttpPost(URL);
				System.out.println(URL);
				httpPost.setEntity(new UrlEncodedFormEntity(params1));
				final HttpResponse httpResponse = httpClient.execute(httpPost);
				final HttpEntity httpEntity = httpResponse.getEntity();

				is = httpEntity.getContent();

			} catch (final UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (final ClientProtocolException e) {
				e.printStackTrace();
			} catch (final IOException e) {
				e.printStackTrace();
			}

			try {
				final BufferedReader reader = new BufferedReader(
						new InputStreamReader(is, "iso-8859-1"), 8);
				final StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}
				is.close();
				json = sb.toString();
				Log.e("JSON", json);
			} catch (final Exception e) {
				Log.e("Buffer Error", "Error converting result " + e.toString());
			}

			return json;
		}
	}

}
