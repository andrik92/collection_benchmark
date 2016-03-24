package com.epam.cdp.andriy.prokip.collection.map.action;

import java.util.Map;

import com.epam.cdp.andriy.prokip.collection.factory.map.MapFactory;

public class MapMemorySize {

	private String keyPattern = "Element %d";
	private String valuePattern = "Element %d";
	static final int K = 1024;

	public String getName() {
		return "memory size()";
	}

	public int getMapMemorySize(MapFactory factory, int limit) {

		int size, i = 0;
		
		System.gc();

		do {
			
			long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
			
			Map <String,String > map = factory.create(limit);	

			while (i < limit) {
				map.put(String.format(keyPattern, i), String.format(valuePattern, i));
				i++;
			}

			long after = Runtime.getRuntime().totalMemory()	- Runtime.getRuntime().freeMemory();
			
			size = (int) (after - before);
	
			size /= K;	
			
		} while (size <= 0);

		return size;
	}

}
