package com.epam.cdp.andriy.prokip.collection.test;

import com.epam.cdp.andriy.prokip.collection.factory.map.MapFactory;
import com.epam.cdp.andriy.prokip.collection.factory.map.MapFactoryImpl;
import com.epam.cdp.andriy.prokip.collection.map.action.MapAction;
import com.epam.cdp.andriy.prokip.collection.map.action.MapGet;
import com.epam.cdp.andriy.prokip.collection.map.action.MapPut;
import com.epam.cdp.andriy.prokip.collection.map.action.MapSize;

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
			new MapPut(),
			new MapGet(),
			new MapSize()
		};// @formatter:on

		System.out.println("\n\tMap Impl");
		System.out.printf("%-30s", "[elements="+ LIMIT + ", runs:" + RUNS + "]");
		
		for (MapAction mapAction : mapActions) {
			System.out.printf("|  %-13s", mapAction.getName());
		}

		System.out.println();

		for (MapFactory factory : factories) {
			TestMapPerformance.run(LIMIT, RUNS, factory, mapActions);
		}
	}

	private static void run(int limit, int runs,
			MapFactory listFactory, MapAction... timeMapActions) {

		System.out.printf("%-30s", listFactory.getName());

		for (MapAction timeMapAction : timeMapActions) {
			long timeInNs = 0;

			System.gc();

			for (int i = 0; i < runs; i++) {
				long time = timeMapAction.timeAction(listFactory.create(limit),
						limit);
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
