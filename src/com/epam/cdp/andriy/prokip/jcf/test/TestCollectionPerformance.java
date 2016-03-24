package com.epam.cdp.andriy.prokip.jcf.test;

import com.epam.cdp.andriy.prokip.jcf.collection.action.CollectionAction;
import com.epam.cdp.andriy.prokip.jcf.collection.action.CollectionMemorySize;
import com.epam.cdp.andriy.prokip.jcf.factory.collection.CollectionFactory;

public class TestCollectionPerformance {

	static void run(int limit, int runs,
			CollectionFactory listFactory, CollectionMemorySize memorySize, CollectionAction... timeListActions) {

		System.out.printf("%-30s", listFactory.getName());

		for (CollectionAction timeListAction : timeListActions) {
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
