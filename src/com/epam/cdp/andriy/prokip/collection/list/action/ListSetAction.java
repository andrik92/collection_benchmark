package com.epam.cdp.andriy.prokip.collection.list.action;

import java.util.List;

public class ListSetAction implements ListAction {

	private String pattern = "Element %d";

	@Override
	public String getName() {
		return "set()";
	}

	@Override
	public long timeAction(List<String> list, int limit) {

		for (int i = 0; i < limit; i++) {
			list.add("");
		}

		long start = System.nanoTime();

		for (int i = 0, size = list.size(); i < limit; i++) {
			list.set(i % size, String.format(pattern, i));
		}

		return System.nanoTime() - start;

	}

}
