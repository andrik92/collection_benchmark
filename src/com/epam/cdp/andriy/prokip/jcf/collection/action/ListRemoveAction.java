package com.epam.cdp.andriy.prokip.jcf.collection.action;

import java.util.Collection;
import java.util.List;

public class ListRemoveAction implements CollectionAction {

	private String pattern = "Element %d";

	@Override
	public String getName() {
		return "remove()";
	}

	@Override
	public long timeAction(Collection<String> collection, int limit) {
		int i;
		List<String> list = (List<String>) collection;

		for (i = 0; i < limit; i++) {
			list.add(String.format(pattern, i));
		}
		long start = System.nanoTime();

		for (i = 0; i < limit; i++) {
			list.remove(0);
		}

		return System.nanoTime() - start;

	}
}
