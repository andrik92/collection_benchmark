package com.epam.cdp.andriy.prokip.jcf.collection.action;

import java.util.Collection;
import java.util.Iterator;

public class CollectionIteratorAction implements CollectionAction {

	private String pattern = "Element %d";

	@Override
	public String getName() {
		return "iterate()";
	}

	@Override
	public long timeAction(Collection<String> collection, int limit) {
		for (int i = 0; i < limit; i++) {
			collection.add(String.format(pattern, i));
		}
		long start = System.nanoTime();
		for (Iterator<String> i = collection.iterator(); i.hasNext();) {
			i.next();
		}
		return System.nanoTime() - start;
	}

}
