package com.teamNikaml.webservicelib.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.teamNikaml.webservicelib.webservice.CallWebservice;

public class Mapper {
	
	private Context context;
	private Object className;
	private List<String> fieldNameList;

	public Object getClassName() {
		return className;
	}

	public Mapper(Context context) {
		super();
		this.context = context;
	}

	public void setClassName(Object className) {
		this.className = className;
	}
	
	
	public void getFieldName()
	{
		Class<?> c = className.getClass();
		System.out.println("classname: "+c.getName());
		fieldNameList = new ArrayList<String>();
		Field[] fields =  c.getDeclaredFields();
		
		System.out.println("fields:"+fields.length);
		for(int i=0;i<fields.length;i++)
			fieldNameList.add(fields[i].getName());
		
		
		System.out.println(fieldNameList);
			}

	
	

}
