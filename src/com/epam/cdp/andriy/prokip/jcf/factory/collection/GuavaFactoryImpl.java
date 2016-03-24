package com.epam.cdp.andriy.prokip.jcf.factory.collection;

import java.util.Collection;

import com.google.common.collect.HashMultiset;

public class GuavaFactoryImpl {

	public static CollectionFactory HASH_MULTISET_FACTORY = new AbstractCollectionFactory(
			"HashMultiSet") {

		@Override
		public Collection<String> create(int capacity) {
			return HashMultiset.create();
		}
	};

	public static CollectionFactory HASH_MULTISET_WITH_SIZE_FACTORY = new AbstractCollectionFactory(
			"HashMultiSet with init size") {

		@Override
		public Collection<String> create(int capacity) {
			return HashMultiset.create(capacity);
		}
	};
}
