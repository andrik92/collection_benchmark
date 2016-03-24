package com.epam.cdp.andriy.prokip.jcf.test;

import com.epam.cdp.andriy.prokip.jcf.collection.action.CollectionAction;
import com.epam.cdp.andriy.prokip.jcf.collection.action.CollectionAddAction;
import com.epam.cdp.andriy.prokip.jcf.collection.action.CollectionIteratorAction;
import com.epam.cdp.andriy.prokip.jcf.collection.action.CollectionMemorySize;
import com.epam.cdp.andriy.prokip.jcf.factory.collection.CollectionFactory;
import com.epam.cdp.andriy.prokip.jcf.factory.collection.SetFactoryImpl;

public class TestSetPerformance {

	static final int LIMIT = 10000;
	static final int RUNS = 100;

	public static void run() {

		CollectionFactory[] factories = {// @formatter:off
				SetFactoryImpl.TREE_SET_FACTORY,
				SetFactoryImpl.HASH_SET_FACTORY,
				SetFactoryImpl.HASH_SET_WITH_SIZE_FACTORY,
				SetFactoryImpl.LINKED_HASH_SET_FACTORY,
				SetFactoryImpl.LINKED_HASH_SET_WITH_SIZE_FACTORY,
				SetFactoryImpl.COWA_SET_FACTORY
				
		};// @formatter:on

		CollectionAction[] listActions = {// @formatter:off
				new CollectionAddAction(),
				new CollectionIteratorAction()
		
		};// @formatter:on

		CollectionMemorySize memorySize = new CollectionMemorySize();

		System.out.println("\n\tSet Impl");
		System.out.printf("%-30s", "[elements=" + LIMIT + ", runs:" + RUNS
				+ "]");

		for (CollectionAction listAction : listActions) {
			System.out.printf("|  %-13s", listAction.getName());
		}

		System.out.printf("|  %-13s\n", memorySize.getName());

		for (CollectionFactory factory : factories) {
			TestCollectionPerformance.run(LIMIT, RUNS, factory, memorySize,
					listActions);
		}
	}
}
