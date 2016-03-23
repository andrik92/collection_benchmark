package com.epam.cdp.andriy.prokip.collection.main;

import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

import com.epam.cdp.andriy.prokip.collection.test.TestListPerformance;
import com.epam.cdp.andriy.prokip.collection.test.TestMapPerformance;

public class Main {

	public static void main(String[] args) {
		// TestListPerformance.run();
		 TestMapPerformance.run();

//		String keyPattern = "Key %d";
//		String valuePattern = "Value %d";
//
//		int limit = 10000;
//		for (int i = 0; i < 100; i++) {
//
//			Map<String, String> map = new HashMap<String, String>();
//
//			System.out.println(map.size());
//
//			long x1 = Runtime.getRuntime().totalMemory()
//					- Runtime.getRuntime().freeMemory();
//			System.out.println(x1);
//			// System.out.println();
//
//			for (int k = 0; k < limit; k++) {
//				map.put(String.format(keyPattern, k),
//						String.format(valuePattern, k));
//			}
//
//			System.out.println("map size " + map.size());
//
//			long x2 = Runtime.getRuntime().totalMemory()- Runtime.getRuntime().freeMemory();
//			System.out.println(x2);
//			long x3 = x2-x1;
//			System.out.println("Map memory size "+ x3 / 1024 / 1024 + "Mb");
//		}
//		
////		System.out.println(Runtime.getRuntime().maxMemory());
//		//java -XX:+PrintFlagsFinal -version 2>&1 | findstr MaxHeapSize  4267704320
//		
//		long maxBytes = Runtime.getRuntime().maxMemory();
//		System.out.println(maxBytes);
//		System.out.println("Max memory: " + maxBytes / 1024 / 1024 + "Mb");
	}

}
