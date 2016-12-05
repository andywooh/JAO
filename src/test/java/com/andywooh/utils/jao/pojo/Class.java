package com.andywooh.utils.jao.pojo;

import java.util.ArrayList;
import java.util.List;

public class Class {
	private String classNum;
	private List<Student> students;
	
	public Class () {
		this.students = new ArrayList<Student>();
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Class [classNum=" + classNum + ", students=" + students + "]";
	}
	
}
