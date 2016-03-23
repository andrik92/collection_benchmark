package com.epam.cdp.andriy.prokip.collection.list.action;

import java.util.List;

public class ListSize implements ListAction {

	private String pattern = "Element %d";

	@Override
	public String getName() {
		return "size()";
	}

	@Override
	public long timeAction(List<String> list, int limit) {

		for (int i = 0; i < limit; i++) {
			list.add(String.format(pattern, i));
		}

		long start = System.nanoTime();

		for (int i = 0; i < limit; i++) {
			list.size();
		}

		return System.nanoTime() - start;
	}

}
