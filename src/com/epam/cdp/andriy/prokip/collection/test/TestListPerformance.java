package com.epam.cdp.andriy.prokip.collection.test;

import com.epam.cdp.andriy.prokip.collection.factory.list.ListFactory;
import com.epam.cdp.andriy.prokip.collection.factory.list.ListFactoryImpl;
import com.epam.cdp.andriy.prokip.collection.list.action.ListAction;
import com.epam.cdp.andriy.prokip.collection.list.action.ListAddAction;
import com.epam.cdp.andriy.prokip.collection.list.action.ListGetAction;
import com.epam.cdp.andriy.prokip.collection.list.action.ListIteratorAction;
import com.epam.cdp.andriy.prokip.collection.list.action.ListSetAction;
import com.epam.cdp.andriy.prokip.collection.list.action.ListMemorySize;

public class TestListPerformance {

	static final int LIMIT = 10000;
	static final int RUNS = 100;

	
	public static void run() {

		ListFactory[] factories = { // @formatter:off
				ListFactoryImpl.VECTOR_FACTORY,
				ListFactoryImpl.VECTOR_WITH_SIZE_FACTORY,
				ListFactoryImpl.ARRAY_LIST_FACTORY,
				ListFactoryImpl.ARRAY_LIST_WITH_SIZE_FACTORY,
				ListFactoryImpl.LINKED_LIST_FACTORY,
				ListFactoryImpl.STACK_FACTORY,
				ListFactoryImpl.COWAL_FACTORY
				
		};// @formatter:on

		ListAction[] listActions = { // @formatter:off
				new ListAddAction(),
				new ListSetAction(),
				new ListGetAction(),
				new ListIteratorAction(),
//				new ListMemorySize()
		
		};// @formatter:on

		 ListMemorySize memorySize = new ListMemorySize();
		
		System.out.println("\n\tList Impl");
		System.out.printf("%-30s", "[elements="+ LIMIT + ", runs:" + RUNS + "]");
		
		for (ListAction listAction : listActions) {
			System.out.printf("|  %-13s", listAction.getName());
		}

		System.out.printf("|  %-13s\n", memorySize.getName());

		for (ListFactory factory : factories) {
			TestListPerformance.run(LIMIT, RUNS, factory, memorySize, listActions);
		}
	}

	private static void run(int limit, int runs,
			ListFactory listFactory, ListMemorySize memorySize, ListAction... timeListActions) {

		System.out.printf("%-30s", listFactory.getName());

		for (ListAction timeListAction : timeListActions) {
			long timeInNs = 0;
			System.gc();

			for (int i = 0; i < runs; i++) {
				long time = timeListAction.timeAction(listFactory.create(limit), limit);
				timeInNs += time;
			}

			long avgTimeInNs = timeInNs / runs;
			double avgTimeInMs = avgTimeInNs / 1000000D;
			System.out.printf("| %8.3f Mills", avgTimeInMs);
		}

		System.out.printf("| %10d Kb\n", memorySize.getListMemorySize(listFactory, limit));
		System.gc();
	}
}
