package com.teamNikaml.webservicelib.model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {

	private Object classObject;

	public Object getClassObject() {
		return classObject;
	}

	public void setClassObject(Object classObject) {
		this.classObject = classObject;
	}

	private void setData(JSONObject json_data, String fieldName,
			Object classData) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, JSONException,
			NoSuchMethodException {
		String setterName = null;
		setterName = "set" + fieldName.substring(0, 1).toUpperCase()
				+ fieldName.substring(1);
	
		Method set = classData.getClass().getMethod(setterName,
				setterName.getClass());
		set.invoke(classData, json_data.getString(fieldName));

	}

	public void parseJson(String result) {

		JSONObject json_data;

		try {
			json_data = new JSONObject(result);

			init(json_data, classObject);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void init(JSONObject json_data, Object classObject) {
		// TODO Auto-generated method stub

		ReflectionModel model = new ReflectionModel();
		model.setClassName(classObject.getClass());
		model.getFieldName();
		List<String> fieldList = model.getFieldNameList();
		List<String> listObjectArrayList = model.getListObjectArrayList();
		List<String> innerClassList = model.getInnerclassList();
		if(fieldList.size()>0)
		parsejsonString(json_data, fieldList, classObject);
		if(innerClassList.size()>0)
		parsejsonObject(json_data, innerClassList, classObject);
		if(listObjectArrayList.size()>0)
		parsejsonObjectArray(json_data, listObjectArrayList, classObject);

	}

	private void parsejsonString(JSONObject json_data, List<String> fieldList,
			Object classObject) {

		try {

			for (int i = 0; i < json_data.length(); i++) {

				for (int j = 0; j < fieldList.size(); j++) {

					setData(json_data, fieldList.get(j), classObject);

				}
			}

		} catch (JSONException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void parsejsonObject(JSONObject json_data,
			List<String> innerClassList, Object classObject) {
		JSONObject jsonObject;

		try {

			for (int i = 0; i < innerClassList.size(); i++) {

				jsonObject = json_data.getJSONObject(innerClassList.get(i));
				Field field = classObject.getClass().getDeclaredField(
						innerClassList.get(i));

				Class<?> listGenericClass = field.getType();

				Object myjsonObject = listGenericClass.newInstance();
				
				init(jsonObject, myjsonObject);

			/*	ReflectionModel model2 = new ReflectionModel();

				model2.setClassName(listGenericClass);

				model2.getFieldName();

				List<String> fieldList1 = model2.getFieldNameList();

				for (int j = 0; j < fieldList1.size(); j++) {

					setData(jsonObject, fieldList1.get(j), myjsonObject);

				}*/

				String setterName = "set"
						+ innerClassList.get(i).substring(0, 1).toUpperCase()
						+ innerClassList.get(i).substring(1);
				Method[] method = classObject.getClass().getMethods();

				for (int k = 0; k < method.length; k++) {

					String methodName = method[k].getName();

					if (methodName.equals(setterName)) {

						method[k].invoke(classObject, myjsonObject);

						break;
					}
				}
				
			}
			
		} catch (JSONException | IllegalAccessException
				| IllegalArgumentException | NoSuchFieldException | InstantiationException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void parsejsonObjectArray(JSONObject json_data,
			List<String> listObjectArrayList, Object classObject) {

		JSONArray jsonArray;
		JSONObject jsonObject;
		Class<?> listGenericClass;
		List<Object> objectList = new ArrayList<Object>();

		ReflectionModel model = new ReflectionModel();

		try {

			for (int k = 0; k < listObjectArrayList.size(); k++) {

				jsonArray = json_data.getJSONArray(listObjectArrayList.get(k));

				for (int i = 0; i < jsonArray.length(); i++) {

					jsonObject = jsonArray.getJSONObject(i);

					Field field = classObject.getClass().getDeclaredField(
							listObjectArrayList.get(k));

					listGenericClass = model.getClassName(field);

					Object myjsonObject = listGenericClass.newInstance();
					init(jsonObject, myjsonObject);

				/*	ReflectionModel model2 = new ReflectionModel();

					model2.setClassName(listGenericClass);

					model2.getFieldName();

					List<String> fieldList1 = model2.getFieldNameList();

					for (int j = 0; j < fieldList1.size(); j++) {

						setData(jsonObject, fieldList1.get(j), myjsonObject);

					}*/

					objectList.add(myjsonObject);
				}

				String setterName = "set"
						+ listObjectArrayList.get(k).substring(0, 1)
								.toUpperCase()
						+ listObjectArrayList.get(k).substring(1);

				Method[] method = classObject.getClass().getMethods();

				for (int i = 0; i < method.length; i++) {

					String methodName = method[i].getName();
					if (methodName.equals(setterName)) {
						method[i].invoke(classObject, objectList);

						break;
					}
				}

			}

		} catch (JSONException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchFieldException | InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} 
	
	
		
		
		
	}


