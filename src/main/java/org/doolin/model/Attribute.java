package org.doolin.model;

public class Attribute {
	private String name;
	private String type;
	private Boolean isEmpty;
	
	public Attribute(String name,String type) {
		this.name = name;
		this.type = type;
		this.isEmpty = null;
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	public synchronized String getType() {
		return type;
	}

	public synchronized void setType(String type) {
		this.type = type;
	}

	public synchronized boolean isEmpty() {
		return isEmpty;
	}

	public synchronized void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	
	
}
