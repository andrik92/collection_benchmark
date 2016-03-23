package com.epam.cdp.andriy.prokip.collection.factory.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListFactoryImpl {
	
	public static ListFactory ARRAY_LIST_FACTORY = new AbstractListFactory("ArrayList") {
		@Override
		public List<String> create(int capacity) {
			return new ArrayList<>();
		}
	};

	public static ListFactory ARRAY_LIST_WITH_SIZE_FACTORY = new AbstractListFactory("ArrayList with init size") {
		@Override
		public List<String> create(int capacity) {
			return new ArrayList<>(capacity);
		}
	};

	public static ListFactory VECTOR_WITH_SIZE_FACTORY = new AbstractListFactory("Vector with init size") {
		@Override
		public List<String> create(int capacity) {
			return new Vector<>(capacity);
		}
	};

	public static ListFactory VECTOR_FACTORY = new AbstractListFactory("Vector") {
		@Override
		public List<String> create(int capacity) {
			return new Vector<>();
		}
	};

	public static ListFactory LINKED_LIST_FACTORY = new AbstractListFactory("LinkedList") {
		@Override
		public List<String> create(int capacity) {
			return new LinkedList<>();
		}
	};

	public static ListFactory STACK_FACTORY = new AbstractListFactory("Stack") {
		@Override
		public List<String> create(int capacity) {
			return new Stack<>();
		}
	};

	public static ListFactory COWAL_FACTORY = new AbstractListFactory("CopyOnWriteArrayList") {
		@Override
		public List<String> create(int capacity) {
			return new CopyOnWriteArrayList<>();
		}
	};

}
