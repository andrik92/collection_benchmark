package com.epam.cdp.andriy.prokip.collection.list.action;

import java.util.List;

public class ListGet implements ListAction {

	private String pattern = "Element %d";

	@Override
	public String getName() {
		return "get()";
	}

	@Override
	public long timeAction(List<String> list, int limit) {
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
