package com.epam.cdp.andriy.prokip.collection.list.action;

import java.util.List;

public class ListAdd implements ListAction {

	private String pattern = "Element %d";

	@Override
	public String getName() {
		return "add()";
	}

	@Override
	public long timeAction(List<String> list, int limit) {
		long start = System.nanoTime();
		for (int i = 0; i < limit; i++) {
			list.add(String.format(pattern, i));
		}
		return System.nanoTime() - start;
	}

}
