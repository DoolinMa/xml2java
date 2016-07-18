package org.doolin.model;

import java.util.List;

public class JavaFileContent {

	private String packageName;
	private String className;
	private List<Attribute> attributes;
	
	public synchronized String getPackageName() {
		return packageName;
	}
	public synchronized void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public synchronized String getClassName() {
		return className;
	}
	public synchronized void setClassName(String className) {
		this.className = className;
	}
	public synchronized List<Attribute> getAttributes() {
		return attributes;
	}
	public synchronized void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
	
	
}

