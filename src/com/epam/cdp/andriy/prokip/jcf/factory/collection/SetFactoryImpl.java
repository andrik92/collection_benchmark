package com.epam.cdp.andriy.prokip.jcf.factory.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetFactoryImpl {

	public static CollectionFactory TREE_SET_FACTORY = new AbstractCollectionFactory(
			"TreeSet") {

		@Override
		public Collection<String> create(int capacity) {
			return new TreeSet<String>();
		}
	};

	public static CollectionFactory HASH_SET_FACTORY = new AbstractCollectionFactory(
			"HashSet") {

		@Override
		public Collection<String> create(int capacity) {
			return new HashSet<String>();
		}
	};
	
	public static CollectionFactory HASH_SET_WITH_SIZE_FACTORY = new AbstractCollectionFactory(
			"HashSet with init size") {

		@Override
		public Collection<String> create(int capacity) {
			return new HashSet<String>(capacity);
		}
	};

	public static CollectionFactory LINKED_HASH_SET_FACTORY = new AbstractCollectionFactory(
			"LinhedHashSet") {

		@Override
		public Collection<String> create(int capacity) {
			return new LinkedHashSet<String>();
		}
	};
	
	public static CollectionFactory LINKED_HASH_SET_WITH_SIZE_FACTORY = new AbstractCollectionFactory(
			"LinhedHashSet with init size") {

		@Override
		public Collection<String> create(int capacity) {
			return new LinkedHashSet<String>(capacity);
		}
	};
	
	public static CollectionFactory COWA_SET_FACTORY = new AbstractCollectionFactory(
			"CopyOnWriteArraySet") {

		@Override
		public Collection<String> create(int capacity) {
			return new CopyOnWriteArraySet<String>();
		}
	};
	
}
