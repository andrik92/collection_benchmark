package com.epam.cdp.andriy.prokip.collection.map.action;

import java.util.Map;

public class MapGet implements MapAction {

	private String keyPattern = "Key %d";
	private String valuePattern = "Value %d";

	@Override
	public String getName() {
		return "get()";
	}

	@Override
	public long timeAction(Map<String, String> map, int limit) {
		for (int i = 0; i < limit; i++) {
			map.put(String.format(keyPattern, i), String.format(valuePattern, i));
		}

		long start = System.nanoTime();
		for (int i = 0, size = map.size(); i < limit; i++) {
			map.get(String.format(keyPattern, i % size));
		}
		return System.nanoTime() - start;
	}

}
