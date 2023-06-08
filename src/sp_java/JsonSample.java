package sp_java;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class JsonSample {
	
	
	
	public void Sample() {
		Gson gson = new Gson();
		//1. parsing json
		//1-1 default
		System.out.println("json string parsing");
		String jsonStr = "{\"id\":1,\"name\":\"Park\"}";
		JsonObject obj = JsonParser.parseString(jsonStr).getAsJsonObject();
		System.out.print("id : ");
		System.out.print(obj.get("id").getAsInt());
		System.out.print(" / name : ");
		System.out.println(obj.get("name").getAsString());
		System.out.println("--------------");
		
		//1-2 parsing json array
		System.out.println("json array string parsing");
		String studentArryStr = "[{'id':1, 'name': 'park'}, {'id':2, 'name':'kim'}]";
		JsonArray jsonAry = JsonParser.parseString(studentArryStr).getAsJsonArray();
		for(int i = 0; i < jsonAry.size(); i++) {
			JsonObject tmpObj = jsonAry.get(i).getAsJsonObject();
			System.out.print("id : ");
			System.out.print(tmpObj.get("id").getAsInt());
			System.out.print(" / name : ");
			System.out.println(tmpObj.get("name").getAsString());
		}
		System.out.println("----------");
		
		//1-3 parsing json include array member
		System.out.println("json string include array member parsing");
		String departmentJson = "{'id' : 1, 'name' : 'HR', 'users' : ['park', 'lee', 'kim' ]}";
		JsonObject departJsonObj = JsonParser.parseString(departmentJson).getAsJsonObject();
		System.out.print("id : ");
		System.out.print(departJsonObj.get("id").getAsInt());
		System.out.print(" / name : ");
		System.out.print(departJsonObj.get("name").getAsString());
		System.out.print(" / users : ");
		JsonArray departUserAry = departJsonObj.get("users").getAsJsonArray();
		for(int i = 0; i < departUserAry.size(); i++) {
			System.out.print(departUserAry.get(i).getAsString());
			if(i < departUserAry.size() -1) {
				System.out.print(", ");
			}
			else {
				System.out.println();
			}
		}
		System.out.println("----------");
			
		//2. json to object
		//2-1 default
		System.out.println("json string to object");
		String jsonStr2 = "{\"id\":1,\"name\":\"Park\"}";
		Student student1 = gson.fromJson(jsonStr2, Student.class);
		System.out.println(student1);
		System.out.println("-------------");
		
		//2-2 json array to object
		System.out.println("json array to array list");
		String studentArryStr2 = "[{'id':1, 'name': 'park'}, {'id':2, 'name':'kim'}]";
		ArrayList<Student> studentAry = gson.fromJson(studentArryStr2, new TypeToken<ArrayList<Student>>(){}.getType());
		for(Student tmpStudent : studentAry) {
			System.out.println(tmpStudent);
		}
		System.out.println("-------------");
		
		//2-3 json include array member to object
		System.out.println("json include array member(string) to object include array list");
		String departmentJson2 = "{'id' : 1, 'name' : 'HR', 'users' : ['park', 'lee', 'kim' ]}";
		Department department = gson.fromJson(departmentJson2, Department.class);
		System.out.println(department);
		System.out.println("-------------");
		
		System.out.println("json include array member(object) to object include array list");
		String lessonJson = "{'name':'math', 'students' : [ {'id':1,'name':'park'}, {'id':2,'name':'kim'} ] }";
		Lesson lesson = gson.fromJson(lessonJson, Lesson.class);
		System.out.println(lesson);
		System.out.println("-------------");
		
		//3. object to json
		//3-1 default
		System.out.println("object to json");
		Student student2 = new Student(2, "kim");
		String studentJson = gson.toJson(student2);
		System.out.println(studentJson);
		System.out.println("------------");
		
		//3-2 arrayList to json
		System.out.println("ArrayList to json");
		ArrayList<Student> studentAry2 = new ArrayList<Student>();
		Student st1 = new Student(1, "park2");
		Student st2 = new Student(2, "kim2");
		studentAry2.add(st1);
		studentAry2.add(st2);
		String studentAryJsonStr = gson.toJson(studentAry2);
		System.out.println(studentAryJsonStr);
		System.out.println("------------");
		
		//3-3 object include ArrayList member to json
		System.out.println("object inclue ArrayList member(string) to json");
		Department department3 = new Department(2, "R&d");
		String departmentJson3 = gson.toJson(department3);
		System.out.println(departmentJson3);
		System.out.println("------------");
		
		System.out.println("object inclue ArrayList member(object) to json");
		Lesson lesson2 = new Lesson("english");
		String lessonJson2 = gson.toJson(lesson2);
		System.out.println(lessonJson2);
		System.out.println("------------");
		
		//4. object to json file
		System.out.println("object to json file");
		Student student4 = new Student(4, "lee");
		FileWriter fw;
		try {
			fw = new FileWriter("./student.json");
			 gson.toJson(student4, fw);
		        fw.flush();
		        fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// json file to object
		System.out.println("json file to object");
		 try {
			Reader reader = new FileReader("./student.json");
			Student student4_2 =gson.fromJson(reader, Student.class);
			System.out.println(student4_2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 System.out.println("json object to json file");
		 JsonObject jsonObject = new JsonObject();
		 jsonObject.addProperty("name", "japanes");
		 
		 JsonObject jsonObjSt1 = new JsonObject();
		 jsonObjSt1.addProperty("id", 5);
		 jsonObjSt1.addProperty("name", "hwang");
		 JsonObject jsonObjSt2 = new JsonObject();
		 jsonObjSt2.addProperty("id", 6);
		 jsonObjSt2.addProperty("name", "woo");
		 JsonArray jsonArySt = new JsonArray();
		 jsonArySt.add(jsonObjSt1);
		 jsonArySt.add(jsonObjSt2);
		 
		 jsonObject.add("students", jsonArySt);
		 
		 FileWriter fw2;
		 try {
			fw2 = new FileWriter("./lesson.json");
		    gson.toJson(jsonObject, fw2);
		    fw2.flush();
		    fw2.close();
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
	}
	public static JsonObject jsonStrToJsonObj(String jsonStr) {
		JsonObject jsonObj = JsonParser.parseString(jsonStr).getAsJsonObject();
		return jsonObj;
	}
	
	public static JsonArray jsonStrToJsonAry(String jsonStr) {
		JsonArray jsonAry = JsonParser.parseString(jsonStr).getAsJsonArray();
		return jsonAry;
	}
	
	public static void printJsonArySample(JsonArray jsonAry) {
		//String studentArryStr = "[{'id':1, 'name': 'park'}, {'id':2, 'name':'kim'}]";
		for(int i = 0; i < jsonAry.size(); i++) {
			JsonObject tmpObj = jsonAry.get(i).getAsJsonObject();
			/*
			Set<String> keySet = tmpObj.keySet();
			for(String key : keySet) {
				System.out.println(key + " : " + tmpObj.get(key).getAsString());
			}*/
			System.out.print("id : ");
			System.out.print(tmpObj.get("id").getAsInt());
			System.out.print(" / name : ");
			System.out.println(tmpObj.get("name").getAsString());
		}
	}
	
	public static void printJsonObjSample(JsonObject jsonObj) {
		//String departmentJson = "{'id' : 1, 'name' : 'HR', 'users' : ['park', 'lee', 'kim' ]}";
		System.out.print("id : ");
		System.out.print(jsonObj.get("id").getAsInt());
		System.out.print(" / name : ");
		System.out.print(jsonObj.get("name").getAsString());
		System.out.print(" / users : ");
		JsonArray departUserAry = jsonObj.get("users").getAsJsonArray();
		for(int i = 0; i < departUserAry.size(); i++) {
			System.out.print(departUserAry.get(i).getAsString());
			if(i < departUserAry.size() -1) {
				System.out.print(", ");
			}
			else {
				System.out.println();
			}
		}
	}
	
	public static <T> T jsonStrToObj(String jsonStr, Class<T> cls) {
		Gson gson = new Gson();
		return gson.fromJson(jsonStr, cls);
	}
	
	public static <T> ArrayList<T> jsonAryStrToArrayList(String jsonStr, TypeToken<?> type) {
		//new TypeToken<ArrayList<Student>>() {}
		Gson gson = new Gson();
		return gson.fromJson(jsonStr, type.getType());
	}
	
	public static <T> String ObjToJsonStr(T obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
	
	public static <T> void ObjToJsonFile(T obj, String filePath) {
		Gson gson = new Gson();
		FileWriter fw;
		try {
			fw = new FileWriter(filePath);
			 gson.toJson(obj, fw);
		        fw.flush();
		        fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static <T> T JsonFileToObj(String filePath, Class<T> cls) {
		Gson gson = new Gson();
		try {
			Reader reader = new FileReader(filePath);
			return gson.fromJson(reader, cls);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	Class<T> type;
	Test(Class<T> cls) {
		type = cls;
	}
	@SuppressWarnings("unchecked")
	public <T> T jsonStrToObj2(String jsonStr) {
		Gson gson = new Gson();
		return (T) gson.fromJson(jsonStr, type);
	}
	@SuppressWarnings( "rawtypes" )
	public ArrayList jsonStrToObj3(String jsonStr) {
		Gson gson = new Gson();
		return (ArrayList) gson.fromJson(jsonStr, type.arrayType());
	}*/
	
	//reference
	//https://howtodoinjava.com/gson/gson-parse-json-array/
	//https://hianna.tistory.com/629#gson3
	//https://hianna.tistory.com/630
	//https://kim-jong-hyun.tistory.com/61
	//https://mikelim.mintocean.com/entry/Gson%EC%9D%84-%EC%9D%B4%EC%9A%A9%ED%95%98%EC%97%AC-JSON-Array%EB%A5%BC-List%EB%A1%9C-%EB%A7%88%EC%83%AC%EB%A7%81
	
}
