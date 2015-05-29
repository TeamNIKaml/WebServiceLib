package com.teamNikaml.webservicelib.model;

import java.lang.reflect.Field;

public class Mapper {
	
	
	private Object className;

	public Object getClassName() {
		return className;
	}

	public void setClassName(Object className) {
		this.className = className;
	}
	
	
	public void getFieldName()
	{
		Class<?> c = className.getClass();
		System.out.println("classname"+c.getName());
		
		Field[] fields =  c.getFields();
		
		for(int i=0;i<fields.length;i++)
			System.out.println(fields[i].getName()+"\t");
		
			}

}
