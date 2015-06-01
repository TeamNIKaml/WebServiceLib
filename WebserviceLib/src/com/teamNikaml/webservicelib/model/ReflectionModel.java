package com.teamNikaml.webservicelib.model;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ReflectionModel {

	private Object className;
	private List<String> fieldNameList = new ArrayList<String>();
	private List<String> listObjectArrayList = new ArrayList<String>();

	public void getFieldName() {
		Class<?> c = className.getClass();
		Field[] fields = c.getDeclaredFields();
		Type type;


		for (int i = 0; i < fields.length; i++) {

			type = fields[i].getType();

			if (type.toString().equals("interface java.util.List")) {
		
				
				listObjectArrayList.add(fields[i].getName());
				

			} else {
				fieldNameList.add(fields[i].getName());
			}

		}

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

	public void setClassName(Object className) {
		this.className = className;
	}

	public List<String> getFieldNameList() {
		return fieldNameList;
	}

	public void setFieldNameList(List<String> fieldNameList) {
		this.fieldNameList = fieldNameList;
	}

	

}
