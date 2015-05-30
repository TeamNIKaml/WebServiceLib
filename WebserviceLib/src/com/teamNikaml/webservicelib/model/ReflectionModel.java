package com.teamNikaml.webservicelib.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReflectionModel {

	public List<String> getFieldName(Object className) {
		Class<?> c = className.getClass();
		List<String> fieldNameList = new ArrayList<String>();
		Field[] fields = c.getDeclaredFields();

	//	System.out.println("fields:" + fields.length);
		for (int i = 0; i < fields.length; i++)
			fieldNameList.add(fields[i].getName());

		return fieldNameList;
	}

}
