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
		// fields[j].set
		Method set = classData.getClass().getMethod(setterName,
				setterName.getClass());
		set.invoke(classData, json_data.getString(fieldName));

	}

	public void parseJson(String result) {
		String setterName;
		JSONObject json_data;
		Method[] method;
		ReflectionModel model = new ReflectionModel();
		model.setClassName(classObject.getClass());
		model.getFieldName();
		List<String> fieldList = model.getFieldNameList();
		List<String> listObjectArrayList = model.getListObjectArrayList();
		List<String> innerClassList = model.getInnerclassList();
		List<Object> objectList = new ArrayList<Object>();
		JSONObject jsonObject;
		JSONArray jsonArray;
		Class<?> listGenericClass = null;
		try {
			
			json_data = new JSONObject(result);
			

			for (int i = 0; i < innerClassList.size(); i++) {
				jsonObject = json_data.getJSONObject(innerClassList.get(i));

				Field field = classObject.getClass().getDeclaredField(
						innerClassList.get(i));

				listGenericClass = field.getType();

				Object myjsonObject = listGenericClass.newInstance();

				ReflectionModel model2 = new ReflectionModel();

				model2.setClassName(listGenericClass);

				model2.getFieldName();

				List<String> fieldList1 = model2.getFieldNameList();

				for (int j = 0; j < fieldList1.size(); j++) {

					setData(jsonObject, fieldList1.get(j), myjsonObject);

				}

				System.out.println("TaskList object:" + myjsonObject);

				setterName = "set"
						+ innerClassList.get(i).substring(0, 1).toUpperCase()
						+ innerClassList.get(i).substring(1);

				method = classObject.getClass().getMethods();

				for (int k = 0; k < method.length; k++) {

					String methodName = method[k].getName();
					System.out.println("outside setTaskList : "
							+ method[k].getName() + " Settername: "
							+ setterName);
					if (methodName.equals(setterName)) {
						System.out.println("indide setTaskList : "
								+ method[k].getName() + " Settername: "
								+ setterName);
						method[k].invoke(classObject, myjsonObject);

						break;
					}
				}
			}

			for (int k = 0; k < listObjectArrayList.size(); k++) {
				jsonArray = json_data.getJSONArray(listObjectArrayList.get(k));

				for (int i = 0; i < jsonArray.length(); i++) {

					jsonObject = jsonArray.getJSONObject(i);

					Field field = classObject.getClass().getDeclaredField(
							listObjectArrayList.get(k));

					listGenericClass = model.getClassName(field);

					Object myjsonObject = listGenericClass.newInstance();

					ReflectionModel model2 = new ReflectionModel();

					model2.setClassName(listGenericClass);

					model2.getFieldName();

					List<String> fieldList1 = model2.getFieldNameList();

					for (int j = 0; j < fieldList1.size(); j++) {

						setData(jsonObject, fieldList1.get(j), myjsonObject);

					}

					objectList.add(myjsonObject);
				}

				setterName = "set"
						+ listObjectArrayList.get(k).substring(0, 1)
								.toUpperCase()
						+ listObjectArrayList.get(k).substring(1);

				method = classObject.getClass().getMethods();

				for (int i = 0; i < method.length; i++) {

					String methodName = method[i].getName();
					if (methodName.equals(setterName)) {
						method[i].invoke(classObject, objectList);

						break;
					}
				}

			}

		} catch (final JSONException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void parsejsonString(String result,List<String> fieldList) {
		JSONObject json_data;
		
		try {
			json_data = new JSONObject(result);
			
			for (int i = 0; i < json_data.length(); i++) {

				for (int j = 0; j < fieldList.size(); j++) {

					setData(json_data, fieldList.get(j), classObject);

					

				}
			}
			
			
		} catch (JSONException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
		
		
	}

	public void parsejsonObject() {

	}

	public void parsejsonObjectArray() {

	}

}
