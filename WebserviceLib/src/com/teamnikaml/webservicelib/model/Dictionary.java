package com.teamnikaml.webservicelib.model;

public class Dictionary {
	


	public Dictionary(String key, String value, int id) {
		super();
		this.key = key;
		this.value = value;
		this.id = id;
	}

	private String key,value;
	private int id=1;

	


	public Dictionary(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
