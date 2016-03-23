package com.epam.cdp.andriy.prokip.collection.factory.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapFactoryImpl {

	public static MapFactory HASH_MAP_FACTORY = new AbstractMapFactory("HashMap") {
		@Override
		public Map<String, String> create(int capacity) {
			return new HashMap<>();
		}
	};

	public static MapFactory HASH_MAP_WITH_SIZE_FACTORY = new AbstractMapFactory("HashMap with init size") {
		@Override
		public Map<String, String> create(int capacity) {
			return new HashMap<>(capacity);
		}
	};

	public static MapFactory TREE_MAP_FACTORY = new AbstractMapFactory("TreeMap") {
		@Override
		public Map<String, String> create(int capacity) {
			return new TreeMap<>();
		}
	};

	public static MapFactory HASHTABLE_FACTORY = new AbstractMapFactory("Hashtable") {
		@Override
		public Map<String, String> create(int capacity) {
			return new Hashtable<>();
		}
	};

	public static MapFactory HASHTABLE_WITH_SIZE_FACTORY = new AbstractMapFactory("Hashtable with init size") {
		@Override
		public Map<String, String> create(int capacity) {
			return new Hashtable<>();
		}
	};

	public static MapFactory LINKED_HASH_MAP_FACTORY = new AbstractMapFactory("LinkedHashMap") {
		@Override
		public Map<String, String> create(int capacity) {
			return new LinkedHashMap<>();
		}
	};

	public static MapFactory LINKED_HASH_MAP_WITH_SIZE_FACTORY = new AbstractMapFactory("LinkedHashMap with init size") {
		@Override
		public Map<String, String> create(int capacity) {
			return new LinkedHashMap<>(capacity);
		}
	};
}
