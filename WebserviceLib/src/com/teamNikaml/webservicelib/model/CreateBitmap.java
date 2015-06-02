package com.teamNikaml.webservicelib.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class CreateBitmap extends Thread {
	
	public  Bitmap  myBitmap;
	
	private  final String src;
	
	public CreateBitmap(String src) {
		
		this.src = src;
		
		start();
	}

	private  Bitmap getBitmapFromURL(String src) {
		Bitmap myBitmap;
	    try {
	        URL url = new URL(src);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setDoInput(true);
	        connection.connect();
	        InputStream input = connection.getInputStream();
	        myBitmap  = BitmapFactory.decodeStream(input);
	       
	    } catch (IOException e) {
	        // Log exception
	    	myBitmap = null;
	    }
		return myBitmap;
	}

	@Override
	public void run()  {
		// TODO Auto-generated method stub
		myBitmap = getBitmapFromURL(src) ;
	}

	public Bitmap getMyBitmap() {
		return myBitmap;
	}

	public void setMyBitmap(Bitmap myBitmap) {
		this.myBitmap = myBitmap;
	}
	
	
	
	
	

}
