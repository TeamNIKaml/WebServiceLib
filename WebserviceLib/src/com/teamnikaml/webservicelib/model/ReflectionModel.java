package com.teamnikaml.webservicelib.model;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class ReflectionModel {

	private Class<?> className;
	private List<String> fieldNameList = new ArrayList<String>();
	private List<String> listObjectArrayList = new ArrayList<String>();
	private List<String> innerclassList = new ArrayList<String>();

	public void getFieldName() {
		
		Field[] fields = className.getDeclaredFields();
		
		Class<?>[] innerclass = className.getDeclaredClasses();
		
	
		Class<?> fieldClass;
    int flag =0;


		for (int i = 0; i < fields.length; i++) {

			fieldClass = fields[i].getType();
			
			flag =0;
			
			for(int j=0;j<innerclass.length;j++)
	    	{
				
				
				if(innerclass[j].getSimpleName().equals(fieldClass.getSimpleName()))
				{
					innerclassList.add(fields[i].getName());
					flag =1;
					break;
				}
	    	}
			
			if(flag == 1)
				continue;
			

			 if (fieldClass.getSimpleName().equals("List")) {
		
				
				listObjectArrayList.add(fields[i].getName());
				

			} else {
				fieldNameList.add(fields[i].getName());
			}

		}

	}
	
	
	public List<String> getInnerclassList() {
		return innerclassList;
	}


	public void setInnerclassList(List<String> innerclassList) {
		this.innerclassList = innerclassList;
	}


	public Class<?> getClassName(Field field)
	{
		
		ParameterizedType listType = (ParameterizedType) field.getGenericType();
		Class<?> listGenericClass = (Class<?>) listType.getActualTypeArguments()[0];
	
		return listGenericClass;
	}

	public List<String> getListObjectArrayList() {
		return listObjectArrayList;
	}

	public void setListObjectArrayList(List<String> listObjectArrayList) {
		this.listObjectArrayList = listObjectArrayList;
	}

	public Object getClassName() {
		return className;
	}

	public void setClassName(Class<?> className) {
		this.className = className;
	}

	public List<String> getFieldNameList() {
		return fieldNameList;
	}

	public void setFieldNameList(List<String> fieldNameList) {
		this.fieldNameList = fieldNameList;
	}

	

}
