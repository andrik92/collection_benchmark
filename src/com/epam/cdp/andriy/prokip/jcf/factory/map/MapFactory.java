package com.epam.cdp.andriy.prokip.jcf.factory.map;

import java.util.Map;

public interface MapFactory {

	Map<String, String> create(int capacity);

	String getName();

}
