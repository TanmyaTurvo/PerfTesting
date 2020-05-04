package com.perf.input.params;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.perf.utils.Utils;

public class CustomerCreateInput {
	
	InputEntries input = new InputEntries();
	public String url = input.domain+"/api/accounts/shipper?fullResponse=true";
	public int customerCount = 5;
	
	public String getCustomerPayload() {
		
		Map<String, Object> mainMap = new HashMap<>();
		mainMap.put("name", "Customer Test " + Utils.getRandomString(5));
		
		Map<String, Object> map = new HashMap<>();
		map.put("_operation", 1);
		map.put("code", 100176);
		map.put("description", "Active");
		mainMap.put("status", map);
		
		List<Map<String,Object>> addresses = new ArrayList<>();
		map = new HashMap<>();
		map.put("primary", true);
		
		List<Double> coordinates = new ArrayList<>();
		coordinates.add(78.3387956);
		coordinates.add(17.421824);
		
		Map<String, Object> subMap = new HashMap<>();
		subMap.put("coordinates", coordinates);
		map.put("gps", subMap);
		map.put("line1", "ISB Rd");
		map.put("line2", null);
		
		subMap = new HashMap<>();
		subMap.put("name", "Hyderabad");
		map.put("city", subMap);
		
		subMap = new HashMap<>();
		subMap.put("name", "Telangana");
		map.put("state", subMap);
		map.put("zip", "500032");
		
		subMap = new HashMap<>();
		subMap.put("name", "India");
		map.put("country", subMap);
		
		subMap = new HashMap<>();
		subMap.put("id", 100614);
		subMap.put("key", "1160");
		subMap.put("value", "Main");
		map.put("type", subMap);
		
		addresses.add(map);
		mainMap.put("addresses", addresses);
		
		return Utils.mapToJson(mainMap);
	}
}
