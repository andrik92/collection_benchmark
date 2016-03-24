package com.epam.cdp.andriy.prokip.jcf.test;

import com.epam.cdp.andriy.prokip.jcf.factory.map.MapFactory;
import com.epam.cdp.andriy.prokip.jcf.factory.map.MapFactoryImpl;
import com.epam.cdp.andriy.prokip.jcf.map.action.MapAction;
import com.epam.cdp.andriy.prokip.jcf.map.action.MapGetAction;
import com.epam.cdp.andriy.prokip.jcf.map.action.MapMemorySize;
import com.epam.cdp.andriy.prokip.jcf.map.action.MapPutAction;

public class TestMapPerformance {

	static final int LIMIT = 10000;
	static final int RUNS = 100;
	
	public static void run() {

		MapFactory[] factories = {// @formatter:off
			MapFactoryImpl.HASH_MAP_FACTORY,
			MapFactoryImpl.HASH_MAP_WITH_SIZE_FACTORY,
			MapFactoryImpl.TREE_MAP_FACTORY,
			MapFactoryImpl.HASHTABLE_FACTORY,
			MapFactoryImpl.HASHTABLE_WITH_SIZE_FACTORY,
			MapFactoryImpl.LINKED_HASH_MAP_FACTORY,
			MapFactoryImpl.LINKED_HASH_MAP_WITH_SIZE_FACTORY
		};// @formatter:on

		MapAction[] mapActions = {// @formatter:off
			new MapPutAction(),
			new MapGetAction(),
//			new MapMemorySize()
		};// @formatter:on

		MapMemorySize memorySize = new MapMemorySize();
		
		System.out.println("\n\tMap Impl");
		System.out.printf("%-30s", "[elements="+ LIMIT + ", runs:" + RUNS + "]");
		
		for (MapAction mapAction : mapActions) {
			System.out.printf("|  %-13s", mapAction.getName());
		}

		System.out.printf("|  %-13s\n", memorySize.getName());

		for (MapFactory factory : factories) {
			TestMapPerformance.run(LIMIT, RUNS, factory, memorySize, mapActions);
		}
	}

	private static void run(int limit, int runs,
			MapFactory factory, MapMemorySize memorySize, MapAction... timeMapActions) {

		System.out.printf("%-30s", factory.getName());

		for (MapAction timeMapAction : timeMapActions) {
			long timeInNs = 0;

			System.gc();

			for (int i = 0; i < runs; i++) {
				long time = timeMapAction.timeAction(factory.create(limit), limit);
				timeInNs += time;
			}

			long avgTimeInNs = timeInNs / runs;
			double avgTimeInMs = avgTimeInNs / 1000000D;
			System.out.printf("| %8.3f Mills", avgTimeInMs);
		}

		System.out.printf("| %10d Kb\n", memorySize.getMapMemorySize(factory, limit));

		System.gc();
	}
}
