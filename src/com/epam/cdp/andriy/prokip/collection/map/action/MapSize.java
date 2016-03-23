package com.epam.cdp.andriy.prokip.collection.map.action;

import java.util.Map;

public class MapSize implements MapAction {

	private String keyPattern = "Element %d";
	private String valuePattern = "Element %d";

	@Override
	public String getName() {
		return "size()";
	}

	@Override
	public long timeAction(Map<String, String> map, int limit) {
		for (int i = 0; i < limit; i++) {
			map.put(String.format(keyPattern, i), String.format(valuePattern, i));
		}

		long start = System.nanoTime();
		for (int i = 0; i < limit; i++) {
			map.size();
		}
		return System.nanoTime() - start;
	}

}
