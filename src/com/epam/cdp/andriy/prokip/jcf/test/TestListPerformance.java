package com.epam.cdp.andriy.prokip.jcf.test;

import com.epam.cdp.andriy.prokip.jcf.collection.action.CollectionAction;
import com.epam.cdp.andriy.prokip.jcf.collection.action.CollectionAddAction;
import com.epam.cdp.andriy.prokip.jcf.collection.action.CollectionIteratorAction;
import com.epam.cdp.andriy.prokip.jcf.collection.action.CollectionMemorySize;
import com.epam.cdp.andriy.prokip.jcf.collection.action.ListGetAction;
import com.epam.cdp.andriy.prokip.jcf.collection.action.ListRemoveAction;
import com.epam.cdp.andriy.prokip.jcf.collection.action.ListSetAction;
import com.epam.cdp.andriy.prokip.jcf.factory.collection.CollectionFactory;
import com.epam.cdp.andriy.prokip.jcf.factory.collection.ListFactoryImpl;

public class TestListPerformance {


	static final int LIMIT = 10000;
	static final int RUNS = 100;

	
	public static void run() {

		CollectionFactory[] factories = { // @formatter:off
				ListFactoryImpl.VECTOR_FACTORY,
				ListFactoryImpl.VECTOR_WITH_SIZE_FACTORY,
				ListFactoryImpl.ARRAY_LIST_FACTORY,
				ListFactoryImpl.ARRAY_LIST_WITH_SIZE_FACTORY,
				ListFactoryImpl.LINKED_LIST_FACTORY,
				ListFactoryImpl.STACK_FACTORY,
				ListFactoryImpl.COWAL_FACTORY
				
		};// @formatter:on

		CollectionAction[] listActions = { // @formatter:off
				new CollectionAddAction(),
				new ListSetAction(),
				new ListGetAction(),
				new CollectionIteratorAction(),
				new ListRemoveAction()
		
		};// @formatter:on

		
		CollectionMemorySize memorySize = new CollectionMemorySize();
		
		System.out.println("\n\tList Impl");
		System.out.printf("%-30s", "[elements="+ LIMIT + ", runs:" + RUNS + "]");
		
		for (CollectionAction listAction : listActions) {
			System.out.printf("|  %-13s", listAction.getName());
		}

		System.out.printf("|  %-13s\n", memorySize.getName());

		for (CollectionFactory factory : factories) {
			TestCollectionPerformance.run(LIMIT, RUNS, factory, memorySize, listActions);
		}
	}
}
