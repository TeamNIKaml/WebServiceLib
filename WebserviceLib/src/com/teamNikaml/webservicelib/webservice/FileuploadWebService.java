package com.teamNikaml.webservicelib.webservice;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import android.os.AsyncTask;
import android.os.Handler;

import com.teamNikaml.webservicelib.model.JsonParser;

public class FileuploadWebService {

	// private static InputStream is = null;

	private String URL;
	private Map<String, String> parametersMap;
	private Map<String, String> fileDataMap;

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

	public FileuploadWebService(String uRL, Map<String, String> parametersMap,
			Map<String, String> fileDataMap, Object classObject) {
		super();
		URL = uRL;
		this.parametersMap = parametersMap;
		this.fileDataMap = fileDataMap;
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
		@SuppressWarnings({ "rawtypes", "resource" })
		protected String doInBackground(String... params) {

			String json = "";
			String serverResponseMessage = null;
			HttpURLConnection conn = null;
			DataOutputStream dos = null;
			String lineEnd = "\r\n";
			String twoHyphens = "--";
			String boundary = "*****";
			int bytesRead, bytesAvailable, bufferSize;
			byte[] buffer;
			int maxBufferSize = 1 * 1024 * 1024;
			FileInputStream[] fileInputStream1 = new FileInputStream[fileDataMap
					.size()];
			FileInputStream fileInputStream = null;
			/*
			 * Iterator entries = parametersMap.entrySet().iterator(); while
			 * (entries.hasNext()) {
			 * 
			 * Map.Entry entry = (Map.Entry) entries.next(); String key =
			 * (String) entry.getKey(); String value = (String)
			 * entry.getValue(); System.out.println("Key = " + key +
			 * ", Value = " + value);
			 * 
			 * params1.add(new BasicNameValuePair(key, value));
			 * 
			 * }
			 */
			try {
				int i = 0;
				Iterator entries = fileDataMap.entrySet().iterator();

				while (entries.hasNext()) {

					Map.Entry entry = (Map.Entry) entries.next();
					// String key = (String) entry.getKey();
					// String value = (String) entry.getValue();
					// System.out.println("Key = " + key + ", Value = " +
					// value);

					fileInputStream = new FileInputStream(new File(entry
							.getValue().toString()));
					
					System.out.println(entry.getValue().toString());
					
					json =  entry.getValue().toString();

				}

				URL url = new URL(URL);

				conn = (HttpURLConnection) url.openConnection();
				conn.setDoInput(true); // Allow Inputs
				conn.setDoOutput(true); // Allow Outputs
				conn.setUseCaches(false); // Don't use a Cached Copy
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Connection", "Keep-Alive");
				conn.setRequestProperty("ENCTYPE", "multipart/form-data");
				conn.setRequestProperty("Content-Type",
						"multipart/form-data;boundary=" + boundary);
				conn.setRequestProperty("uploaded_file", "");

				entries = fileDataMap.entrySet().iterator();

				while (entries.hasNext()) {

					Map.Entry entry = (Map.Entry) entries.next();
					conn.setRequestProperty(entry.getKey().toString(), entry
							.getValue().toString());
					System.out.println("file path : "+entry.getValue().toString());

				}

				entries = parametersMap.entrySet().iterator();

				while (entries.hasNext()) {

					Map.Entry entry = (Map.Entry) entries.next();
					conn.setRequestProperty(entry.getKey().toString(), entry
							.getValue().toString());

				}

				i = 0;
				dos = new DataOutputStream(conn.getOutputStream());
				/*entries = fileDataMap.entrySet().iterator();

				while (entries.hasNext()) {

					Map.Entry entry = (Map.Entry) entries.next();

					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\""
							+ entry.getKey().toString() + "\";filename="
							+ entry.getValue().toString() + "" + lineEnd);

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

					i++;

				}*/

				entries = parametersMap.entrySet().iterator();

				while (entries.hasNext()) {

					Map.Entry entry = (Map.Entry) entries.next();

					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\""
							+ entry.getKey().toString() + "\"" + lineEnd);
					dos.writeBytes(lineEnd);

					// assign value
					dos.writeBytes(entry.getValue().toString());
					dos.writeBytes(lineEnd);
					dos.writeBytes(twoHyphens + boundary + lineEnd);

				}
				
				
				
				dos.writeBytes(twoHyphens + boundary + lineEnd);
				dos.writeBytes(twoHyphens + boundary + lineEnd);
				dos.writeBytes("Content-Disposition: form-data; name=\"uploaded_file\";filename="
						+ json + "" + lineEnd);

				dos.writeBytes(lineEnd);

				// create a buffer of maximum size
				bytesAvailable = fileInputStream.available();

				bufferSize = Math.min(bytesAvailable, maxBufferSize);
				buffer = new byte[bufferSize];

				// read file and write it into form...
				bytesRead = fileInputStream.read(buffer, 0, bufferSize);

				while (bytesRead > 0) {

					dos.write(buffer, 0, bufferSize);
					bytesAvailable = fileInputStream.available();
					bufferSize = Math.min(bytesAvailable, maxBufferSize);
					bytesRead = fileInputStream.read(buffer, 0, bufferSize);

				}

				// send multipart form data necesssary after file data...
				dos.writeBytes(lineEnd);
				dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
				
				
				
				
				
				

				int serverResponseCode = conn.getResponseCode();
				serverResponseMessage = conn.getResponseMessage();

				System.out.println(serverResponseMessage);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return serverResponseMessage;
		}
	}

}
