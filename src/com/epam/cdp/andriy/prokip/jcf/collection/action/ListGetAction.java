package com.epam.cdp.andriy.prokip.jcf.collection.action;

import java.util.Collection;
import java.util.List;

public class ListGetAction implements CollectionAction {

	private String pattern = "Element %d";

	@Override
	public String getName() {
		return "get()";
	}

	@Override
	public long timeAction(Collection<String> collection, int limit) {
		
		List<String> list = (List<String>) collection; 
		
		for (int i = 0; i < limit; i++) {
			list.add(String.format(pattern, i));
		}

		long start = System.nanoTime();
		for (int i = 0, size = list.size(); i < limit; i++) {
			list.get(i % size);
		}
		return System.nanoTime() - start;
	}

}
