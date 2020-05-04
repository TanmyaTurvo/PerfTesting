package com.perf.utils;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class Utils {
	
	public static String mapToJson(Map<String,Object> map) {
		Gson gson = new Gson();
		Type gsonType = new TypeToken<HashMap<String,Object>>(){}.getType();
		String gsonString = gson.toJson(map,gsonType);
		return gsonString;
	}
	
	public static String getRandomString(int len) { 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(len); 
        for (int i = 0; i < len ; i++) { 
            int index = (int)(AlphaNumericString.length() * Math.random()); 
            sb.append(AlphaNumericString.charAt(index)); 
        } 
        return sb.toString(); 
    }
	
	public static String getValueFromJson(StringBuilder sb, String key) {
		JsonParser parser = new JsonParser();
		JsonElement jsonTree = parser.parse(sb.toString());
		JsonObject jsonObject = jsonTree.getAsJsonObject();
		JsonElement value = jsonObject.get(key);
		return value.toString();
	}
	
}
