package sp_java;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class JsonSample {
	public void Sample() {
		JsonElement jsonElement = JsonParser.parseString("{ \"key\":\"value\" }");

		System.out.println(jsonElement.toString());
		
		JsonParser parser = new JsonParser();
		jsonElement = parser.parse("{ \"key\":\"value\" }");
		String name = jsonElement.getAsJsonObject().get("key").getAsString();
		System.out.println(name);
		
		//Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("key", "value");
		jsonObject.addProperty("key2", 1);
		String json = jsonObject.toString();
		//String json = Gson.toJson(jsonObject);
		System.out.println(json);
		
	}
	

	//https://hianna.tistory.com/629
	//https://dejavuhyo.github.io/posts/generating-parsing-json-using-gson/

}
