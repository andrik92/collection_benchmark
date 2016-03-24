package com.epam.cdp.andriy.prokip.collection.list.action;

import java.util.List;

import com.epam.cdp.andriy.prokip.collection.factory.list.ListFactory;

public class ListMemorySize {

	private String pattern = "Element %d";
	static final int K = 1024;

	public String getName() {
		return "memory size()";
	}
	
	public int getListMemorySize(ListFactory factory, int limit) {

		int size = 0;
		System.gc();
		
		do {
			
			long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
			
			List<String> list = factory.create(limit);

			for (int i = 0; i < limit; i++) {
				list.add(String.format(pattern, i));
			}
		
			long after = Runtime.getRuntime().totalMemory()	- Runtime.getRuntime().freeMemory();
			
			size = (int) (after - before);
	
			size /= K;	
			
		} while (size <= 0);

		return size;
	}

}
