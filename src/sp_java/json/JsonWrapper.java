package sp_java.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

/*
 * usage example
 	JsonWrapper<Lesson> jw = new JsonWrapper<Lesson>() {};  //익명클래스로 사용해야함
	Lesson l = jw.jsonStrToObj(lessonJsonStr);
	jw.ObjToJsonFile(l, "./Lesson.json");
	Lesson l2 = jw.JsonFileToObj("./Lesson.json");
 */
public class JsonWrapper <T>{
	 private final Type type;
	 Gson gson;
	 
	 protected JsonWrapper() {
		 Type superclass = getClass().getGenericSuperclass();
	     if (superclass instanceof Class) {
	    	 throw new RuntimeException("Missing type parameter.");
	     }
	     this.type = ((ParameterizedType) superclass).getActualTypeArguments()[0];
	     this.gson = new Gson();
	 }
	 
	 public Type getType() {
		 return this.type;
	 }
	 
	 public JsonObject jsonStrToJsonObj(String jsonStr) {
		 JsonObject jsonObj = JsonParser.parseString(jsonStr).getAsJsonObject();
		 return jsonObj;
	 }
		
	 public JsonArray jsonStrToJsonAry(String jsonStr) {
		 JsonArray jsonAry = JsonParser.parseString(jsonStr).getAsJsonArray();
		 return jsonAry;
	 }
		
	 @SuppressWarnings("unused")
	 private void printJsonArySample(JsonArray jsonAry) {
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

	 public T jsonStrToObj(String jsonStr) {
		 return gson.fromJson(jsonStr, this.type);
	 }
		
	 public ArrayList<T> jsonAryStrToArrayList(String jsonStr) {
		 return gson.fromJson(jsonStr, TypeToken.getParameterized(ArrayList.class, this.type).getType());
	 }
	 
	 public String ObjToJsonStr(T obj) {
		return gson.toJson(obj);
	 }
	 
	 public void ObjToJsonFile(T obj, String filePath) {
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
		
	 public T JsonFileToObj(String filePath) {
		 try {
			 Reader reader = new FileReader(filePath);
			 return gson.fromJson(reader, type);
		 } catch (FileNotFoundException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 return null;
		}
	 }
}
