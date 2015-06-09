package com.teamNikaml.webservicelib.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import com.teamNikaml.webservicelib.model.Dictionary;
import com.teamNikaml.webservicelib.model.JsonParser;

public class CallWebservice {

	private static InputStream is = null;

	private String URL;

	private Object classObject;
	private List<Dictionary> parameterList = new ArrayList<Dictionary>();

	private static Handler myHandler;

	public static void setHandler(Handler h) {
		myHandler = h;
	}

	private void callHandler() {

		if (myHandler != null) {
			myHandler.sendEmptyMessage(1);
		}
	}

	/*
	 * public CallWebservice(Context context, String uRL, Map<String, String>
	 * parametersMap, Object classObject) { super(); // this.context = context;
	 * URL = uRL; this.parametersMap = parametersMap; this.classObject =
	 * classObject; }
	 */

	public CallWebservice(String uRL, Object classObject,
			List<Dictionary> parameterList) {
		super();
		URL = uRL;
		this.classObject = classObject;
		this.parameterList = parameterList;
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
			JsonParser jsonParser = new JsonParser();
			jsonParser.setClassObject(classObject);
			jsonParser.parseJson(result);
			callHandler();
		}

		@Override
		protected String doInBackground(String... params) {

			String json = "";
			final List<BasicNameValuePair> params1 = new ArrayList<BasicNameValuePair>();
			Dictionary dictionary;
			for (int i = 0; i < parameterList.size(); i++) {
				dictionary = parameterList.get(i);
				params1.add(new BasicNameValuePair(dictionary.getKey(),
						dictionary.getValue()));
			}
			try {

				HttpPost httpPost = null;
				final DefaultHttpClient httpClient = new DefaultHttpClient();
				httpPost = new HttpPost(URL);
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
