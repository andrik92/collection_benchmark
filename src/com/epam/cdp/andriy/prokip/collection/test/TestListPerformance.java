package com.epam.cdp.andriy.prokip.collection.test;

import com.epam.cdp.andriy.prokip.collection.factory.list.ListFactory;
import com.epam.cdp.andriy.prokip.collection.factory.list.ListFactoryImpl;
import com.epam.cdp.andriy.prokip.collection.list.action.ListAction;
import com.epam.cdp.andriy.prokip.collection.list.action.ListAdd;
import com.epam.cdp.andriy.prokip.collection.list.action.ListGet;
import com.epam.cdp.andriy.prokip.collection.list.action.ListIterator;
import com.epam.cdp.andriy.prokip.collection.list.action.ListSet;
import com.epam.cdp.andriy.prokip.collection.list.action.ListSize;

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
				new ListAdd(),
				new ListSet(),
				new ListGet(),
				new ListIterator(),
				new ListSize()
		
		};// @formatter:on

		System.out.println("\n\tList Impl");
		System.out.printf("%-30s", "[elements="+ LIMIT + ", runs:" + RUNS + "]");
		
		for (ListAction listAction : listActions) {
			System.out.printf("|  %-13s", listAction.getName());
		}

		System.out.println();

		for (ListFactory factory : factories) {
			TestListPerformance.run(LIMIT, RUNS, factory, listActions);
		}
	}

	private static void run(int limit, int runs, ListFactory listFactory, ListAction... timeListActions) {

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

		System.out.println();
		System.gc();
	}
}
