package com.epam.cdp.andriy.prokip.collection.list.action;

import java.util.List;

public interface ListAction {

	String getName();

	long timeAction(List<String> list, int capacity);
}
