package com.epam.cdp.andriy.prokip.collection.list.action;

import java.util.Iterator;
import java.util.List;

public class ListIteratorAction implements ListAction {

	private String pattern = "Element %d";

	@Override
	public String getName() {
		return "iterate()";
	}

	@Override
	public long timeAction(List<String> list, int limit) {
		for (int i = 0; i < limit; i++) {
			list.add(String.format(pattern, i));
		}
		long start = System.nanoTime();
		for (Iterator<String> i = list.iterator(); i.hasNext();) {
			i.next();
		}
		return System.nanoTime() - start;
	}

}
