package com.epam.cdp.andriy.prokip.jcf.map.action;

import java.util.Map;

public class MapPutAction implements MapAction {

	private String keyPattern = "Key %d";
	private String valuePattern = "Value %d";

	@Override
	public String getName() {
		return "put()";
	}

	@Override
	public long timeAction(Map<String, String> map, int limit) {
		long start = System.nanoTime();
		for (int i = 0; i < limit; i++) {
			map.put(String.format(keyPattern, i), String.format(valuePattern, i));
		}
		return System.nanoTime() - start;
	}

}
