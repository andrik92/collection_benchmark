package com.epam.cdp.andriy.prokip.jcf.collection.action;

import java.util.Collection;

public interface CollectionAction {

	String getName();

	long timeAction(Collection<String> collection, int capacity);
}
