package com.epam.cdp.andriy.prokip.jcf.collection.action;

import java.util.Collection;

import com.epam.cdp.andriy.prokip.jcf.factory.collection.CollectionFactory;

public class CollectionMemorySize {

	private String pattern = "Element %d";
	static final int K = 1024;

	public String getName() {
		return "memory size()";
	}
	
	public int getListMemorySize(CollectionFactory factory, int limit) {

		int size = 0;
		System.gc();
		
		do {
			
			long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
			
			Collection<String> list = factory.create(limit);

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
