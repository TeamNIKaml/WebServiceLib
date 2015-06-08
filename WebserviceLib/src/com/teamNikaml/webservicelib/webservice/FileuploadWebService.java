package com.teamNikaml.webservicelib.webservice;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;
import android.os.Handler;

import com.teamNikaml.webservicelib.model.Dictionary;
import com.teamNikaml.webservicelib.model.JsonParser;

public class FileuploadWebService {

	// private static InputStream is = null;

	private String URL;
	// private Map<String, String> parametersMap;
	// private Map<String, String> fileDataMap;
	private List<Dictionary> parameterList = new ArrayList<Dictionary>();

	private List<Dictionary> fileList = new ArrayList<Dictionary>();
	private List<Dictionary> dataList = new ArrayList<Dictionary>();

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

	public FileuploadWebService(String uRL, List<Dictionary> parameterList,
			Object classObject) {
		super();
		URL = uRL;
		this.parameterList = parameterList;
		this.classObject = classObject;
	}

	public void getService() {

		new FileUploadWebserviceAsyncTask().execute("Fileupload");

	}

	private class FileUploadWebserviceAsyncTask extends
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

			HttpURLConnection conn = null;
			DataOutputStream dos = null;
			String lineEnd = "\r\n";
			String twoHyphens = "--";
			String boundary = "*****";
			int bytesRead, bytesAvailable, bufferSize;
			byte[] buffer;
			int maxBufferSize = 1 * 1024 * 1024;
			FileInputStream[] fileInputStream = null;

			try {

				Dictionary dictionary;

				for (int i = 0; i < parameterList.size(); i++) {
					dictionary = parameterList.get(i);
					if (dictionary.getId() == 1)
						dataList.add(dictionary);
					else
						fileList.add(dictionary);
				}

				if (fileList.size() > 0) {
					fileInputStream = new FileInputStream[fileList.size()];

					for (int i = 0; i < fileList.size(); i++) {
						dictionary = fileList.get(i);
						fileInputStream[i++] = new FileInputStream(new File(
								dictionary.getValue()));
					}

				}

				// System.out.println("after iterator"+fileDataMap);

				URL url = new URL(URL);

				conn = (HttpURLConnection) url.openConnection();
				conn.setDoInput(true); // Allow Inputs
				// conn.setDoOutput(true); // Allow Outputs
				conn.setUseCaches(false); // Don't use a Cached Copy

				// conn.setRequestProperty("User-Agent","Mozilla/5.0 ( compatible ) ");
				// conn.setRequestProperty("Accept","*/*");
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Connection", "Keep-Alive");
				conn.setRequestProperty("ENCTYPE", "multipart/form-data");
				conn.setRequestProperty("Content-Type",
						"multipart/form-data;boundary=" + boundary);

				for (int i = 0; i < dataList.size(); i++) {
					dictionary = dataList.get(i);

					conn.setRequestProperty(dictionary.getKey(),
							dictionary.getValue());

				}

				for (int i = 0; i < fileList.size(); i++) {
					dictionary = fileList.get(i);

					conn.setRequestProperty(dictionary.getKey(),
							dictionary.getValue());

				}
				
				System.out.println("dataList.size():"+dataList.size()+" fileList.size():"+fileList.size());

				dos = new DataOutputStream(conn.getOutputStream());
				
				for (int i = 0; i < dataList.size(); i++) {
					dictionary = dataList.get(i);

					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\""
							+ dictionary.getKey() + "\"" + lineEnd);
					dos.writeBytes(lineEnd);

					// assign value
					dos.writeBytes(dictionary.getValue().toString());
					dos.writeBytes(lineEnd);
					dos.writeBytes(twoHyphens + boundary + lineEnd);

				}
				
				

				for (int i = 0; i < fileList.size(); i++) {
					dictionary = fileList.get(i);

					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\""
							+ dictionary.getKey() + "\";filename="
							+ dictionary.getValue() + "" + lineEnd);

					dos.writeBytes(lineEnd);

					// create a buffer of maximum size
					bytesAvailable = fileInputStream[i].available();

					bufferSize = Math.min(bytesAvailable, maxBufferSize);
					buffer = new byte[bufferSize];

					// read file and write it into form...
					bytesRead = fileInputStream[i].read(buffer, 0, bufferSize);

					while (bytesRead > 0) {

						dos.write(buffer, 0, bufferSize);
						bytesAvailable = fileInputStream[i].available();
						bufferSize = Math.min(bytesAvailable, maxBufferSize);
						bytesRead = fileInputStream[i].read(buffer, 0,
								bufferSize);

					}

					// send multipart form data necesssary after file data...
					dos.writeBytes(lineEnd);
					dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

				}

				

				

				for (int i = 0; i < fileList.size(); i++) {
					fileInputStream[i].close();

				}
				
				dos.close();

				json = "{status:" + conn.getResponseCode()
						+ ",status_message:\"" + conn.getResponseMessage()
						+ "\"}";

				if (conn.getResponseCode() == 200) {
					final BufferedReader reader = new BufferedReader(
							new InputStreamReader(conn.getInputStream(),
									"iso-8859-1"), 8);
					final StringBuilder sb = new StringBuilder();
					String line = null;
					while ((line = reader.readLine()) != null) {
						sb.append(line);
					}

					json = sb.toString();
				}
				System.out.println("json: " + json);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return json;
		}
	}

}
