package com.epam.cdp.andriy.prokip.jcf.test;

import com.epam.cdp.andriy.prokip.jcf.collection.action.CollectionAction;
import com.epam.cdp.andriy.prokip.jcf.collection.action.CollectionAddAction;
import com.epam.cdp.andriy.prokip.jcf.collection.action.CollectionIteratorAction;
import com.epam.cdp.andriy.prokip.jcf.collection.action.CollectionMemorySize;
import com.epam.cdp.andriy.prokip.jcf.factory.collection.CollectionFactory;
import com.epam.cdp.andriy.prokip.jcf.factory.collection.QueueFactoryImpl;

public class TestQueuePerformance {


	static final int LIMIT = 10000;
	static final int RUNS = 100;

	public static void run() {

		CollectionFactory[] factories = {// @formatter:off
			QueueFactoryImpl.ARRAY_DEQUEUE_FACTORY,
			QueueFactoryImpl.ARRAY_DEQUEUE_WITH_SIZE_FACTORY,
			QueueFactoryImpl.PRIORITY_QUEUE_FACTORY,
			QueueFactoryImpl.PRIORITY_QUEUE_WITH_SIZE_FACTORY
				
		};// @formatter:on

		CollectionAction[] listActions = {// @formatter:off
				new CollectionAddAction(),
				new CollectionIteratorAction()
		
		};// @formatter:on

		CollectionMemorySize memorySize = new CollectionMemorySize();

		System.out.println("\n\tQueue Impl");
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
