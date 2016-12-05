package com.andywooh.utils.jao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;
import com.andywooh.utils.jao.pojo.Class;
import com.andywooh.utils.jao.pojo.Student;
import com.andywooh.utils.jao.util.FileUtil;
import com.andywooh.utils.jao.JAOUtil;

public class TestClass {

	/**
	 * 当前的工作目录（工程所在目录）
	 */
	private static final String RELATIVELY_PATH = System.getProperty("user.dir");

	/**
	 * JSON文件目录
	 */
	private static final String STUDENT_JSONFILE = RELATIVELY_PATH + "\\" + "src\\test\\resources\\Student.json";
	private static final String CLASS_JSONFILE = RELATIVELY_PATH + "\\" + "src\\test\\resources\\Class.json";
	private static final String LIST_JSONFILE = RELATIVELY_PATH + "\\" + "src\\test\\resources\\List.json";
	private static final String MAP_JSONFILE = RELATIVELY_PATH + "\\" + "src\\test\\resources\\Map.json";
	
	/**
	 * JSON转简单对象
	 */
	@Test
	public void testJsonToObject() {
		String jsonStr = FileUtil
				.getFileAsString(STUDENT_JSONFILE);

		Student student = JAOUtil.jsonToObject(jsonStr, Student.class);
//		System.out.println(student);
		Assert.assertNotNull(student);
		
		String str = "{name:andywooh,age:26,gender:male,address:311th, Baicao Road}";
		Student student2 = JAOUtil.jsonToObject(jsonStr, Student.class);
		Assert.assertNotNull(student2);
	}

	/**
	 * JSON转复杂对象
	 */
	@Test
	public void testJsonToObject2() {
		String jsonStr = FileUtil
				.getFileAsString(CLASS_JSONFILE);

		Class classes2 = JAOUtil.jsonToObject(jsonStr, Class.class);
		for (Student stu : classes2.getStudents()) {
				System.out.println(stu.toString());
		}
	}

	/**
	 * JSON转List
	 */
	@Test
	public void testJsonToList() {
		String jsonStr = FileUtil
				.getFileAsString(LIST_JSONFILE);

		List<Class> classes2 = JAOUtil.jsonToList(jsonStr, Class.class);
		for (Class one : classes2) {
			for (Student stu : one.getStudents()) {
				System.out.println(stu.toString());
			}
		}
	}

	/**
	 * JSON转MAP
	 */
	@Test
	public void testJsonToMap() {
		String jsonStr = FileUtil
				.getFileAsString(MAP_JSONFILE);
		Map<String, Student> result = JAOUtil.jsonToMap(jsonStr, String.class, Student.class);

		Iterator<Entry<String, Student>> it = result.entrySet().iterator();
		while (it.hasNext()){
			Entry<String, Student> stu = it.next();
			System.out.println(stu.getValue());
		}
	}

	/**
	 * 简单对象转JSON
	 */
	@Test
	public void testObjectToJson() {
		Student stu = new Student();
		stu.setName("Endy Woo");
		stu.setAge(12);
		stu.setGender("male");
		stu.setAddress("311th, WhiteGrass Road");

		String jsonStr = JAOUtil.objectToJson(stu);
		System.out.println(jsonStr);
	}

	/**
	 * 复杂对象转JSON
	 */
	@Test
	public void testObjectToJson2() {
		Student stu = new Student();
		stu.setName("Endy Woo");
		stu.setAge(12);
		stu.setGender("male");
		stu.setAddress("211th, WhiteGrass Road");
		Student stu2 = new Student();
		stu2.setName("Cathy Sing");
		stu2.setAge(13);
		stu2.setGender("female");
		stu2.setAddress("311th, WhiteGrass Road");

		Class classs = new Class();
		classs.setClassNum("6001");
		classs.getStudents().add(stu);
		classs.getStudents().add(stu2);

		String jsonStr = JAOUtil.objectToJson(classs);
		System.out.println(jsonStr);
	}	
}