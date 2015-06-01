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
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.teamNikaml.webservicelib.model.ReflectionModel;
import com.teamNikaml.webservicelib.responseModel.TaskResponseModel;

public class CallWebservice {

	private static InputStream is = null;
	// private Context context;
	// private static User user;
	private String URL;
	private Map<String, String> parametersMap;
	private Object classObject;

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

	private class WebserviceAsyncTask extends
			AsyncTask<String, Integer, String> {

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);

			JSONObject json_data;
			ReflectionModel model = new ReflectionModel();

			model.setClassName(classObject);

			model.getFieldName();

			List<String> fieldList = model.getFieldNameList();
			List<String> listObjectArrayList = model.getListObjectArrayList();

			try {
				json_data = new JSONObject(result);

				for (int i = 0; i < json_data.length(); i++) {

					String setterName = null;
					for (int j = 0; j < fieldList.size(); j++) {
						setterName = "set"
								+ fieldList.get(j).substring(0, 1)
										.toUpperCase()
								+ fieldList.get(j).substring(1);
						// fields[j].set
						Method set = classObject.getClass().getMethod(
								setterName, setterName.getClass());
						set.invoke(classObject,
								json_data.getString(fieldList.get(j)));

					}

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
			}
			System.out.println(classObject);

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
