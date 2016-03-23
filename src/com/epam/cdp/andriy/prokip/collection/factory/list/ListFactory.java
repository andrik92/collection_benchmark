package com.epam.cdp.andriy.prokip.collection.factory.list;

import java.util.List;

public interface ListFactory {

	List<String> create(int capacity);

	String getName();
}
