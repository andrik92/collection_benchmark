package com.epam.cdp.andriy.prokip.jcf.factory.collection;

import java.util.Collection;

public interface CollectionFactory {

	Collection<String> create(int capacity);

	String getName();
}
