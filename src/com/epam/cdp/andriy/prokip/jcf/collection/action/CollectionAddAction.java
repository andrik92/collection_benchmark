package com.epam.cdp.andriy.prokip.jcf.collection.action;

import java.util.Collection;

public class CollectionAddAction implements CollectionAction {

	private String pattern = "Element %d";

	@Override
	public String getName() {
		return "add()";
	}

	@Override
	public long timeAction(Collection<String> collection, int limit) {
		long start = System.nanoTime();
		for (int i = 0; i < limit; i++) {
			collection.add(String.format(pattern, i));
		}
		return System.nanoTime() - start;
	}

}
