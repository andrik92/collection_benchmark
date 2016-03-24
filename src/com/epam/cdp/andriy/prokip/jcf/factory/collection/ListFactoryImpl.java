package com.epam.cdp.andriy.prokip.jcf.factory.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListFactoryImpl {
	
	public static CollectionFactory ARRAY_LIST_FACTORY = new AbstractCollectionFactory("ArrayList") {
		@Override
		public Collection<String> create(int capacity) {
			return new ArrayList<>();
		}
	};

	public static CollectionFactory ARRAY_LIST_WITH_SIZE_FACTORY = new AbstractCollectionFactory("ArrayList with init size") {
		@Override
		public Collection<String> create(int capacity) {
			return new ArrayList<>(capacity);
		}
	};

	public static CollectionFactory VECTOR_WITH_SIZE_FACTORY = new AbstractCollectionFactory("Vector with init size") {
		@Override
		public Collection<String> create(int capacity) {
			return new Vector<>(capacity);
		}
	};

	public static CollectionFactory VECTOR_FACTORY = new AbstractCollectionFactory("Vector") {
		@Override
		public Collection<String> create(int capacity) {
			return new Vector<>();
		}
	};

	public static CollectionFactory LINKED_LIST_FACTORY = new AbstractCollectionFactory("LinkedList") {
		@Override
		public Collection<String> create(int capacity) {
			return new LinkedList<>();
		}
	};

	public static CollectionFactory STACK_FACTORY = new AbstractCollectionFactory("Stack") {
		@Override
		public Collection<String> create(int capacity) {
			return new Stack<>();
		}
	};

	public static CollectionFactory COWAL_FACTORY = new AbstractCollectionFactory("CopyOnWriteArrayList") {
		@Override
		public Collection<String> create(int capacity) {
			return new CopyOnWriteArrayList<>();
		}
	};

}
