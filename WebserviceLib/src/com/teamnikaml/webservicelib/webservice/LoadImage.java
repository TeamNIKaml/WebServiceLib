/**
 * @author Nikhil V
 *
 * Jun 10, 2015
 */
package com.teamnikaml.webservicelib.webservice;

import java.io.InputStream;
import java.net.URL;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

/**
 * @author Nikhil V
 * 
 */
public class LoadImage {

	private String URL;
	private ImageView myImageView;
	private ProgressDialog pDialog;
	private Context context;
	private Bitmap bitmap;

	public LoadImage(String uRL, ImageView myImageView, Context context) {
		super();
		URL = uRL;
		this.myImageView = myImageView;
		this.context = context;
	}

	public void getImage() {
		
		//executeOnExecutor
		
	//	new LoadImageAsyncTask().ex
		

		new LoadImageAsyncTask().execute("LoadImage");

	}

	private class LoadImageAsyncTask extends AsyncTask<String, String, Bitmap> {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(context);
			pDialog.setMessage("Loading Image ....");
			pDialog.show();

		}

		protected Bitmap doInBackground(String... args) {
			try {
				bitmap = BitmapFactory.decodeStream((InputStream) new URL(URL)
						.getContent());

			} catch (Exception e) {
				e.printStackTrace();
			}
			return bitmap;
		}

		protected void onPostExecute(Bitmap image) {

			if (image != null) {
				bitmap = Bitmap.createScaledBitmap(bitmap, 1000, 700, false);

				myImageView.setImageBitmap(bitmap);

			}

			pDialog.dismiss();

		}
	}

}
