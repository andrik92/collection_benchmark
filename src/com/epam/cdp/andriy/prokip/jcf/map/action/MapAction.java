package com.epam.cdp.andriy.prokip.jcf.map.action;

import java.util.Map;

public interface MapAction {

	String getName();

	long timeAction(Map<String, String> list, int limit);
}
