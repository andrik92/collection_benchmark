package com.epam.cdp.andriy.prokip.jcf.main;

import com.epam.cdp.andriy.prokip.jcf.test.TestListPerformance;
import com.epam.cdp.andriy.prokip.jcf.test.TestMapPerformance;
import com.epam.cdp.andriy.prokip.jcf.test.TestMultisetPerformance;
import com.epam.cdp.andriy.prokip.jcf.test.TestQueuePerformance;
import com.epam.cdp.andriy.prokip.jcf.test.TestSetPerformance;

public class Main {

	public static void main(String[] args) {
		 
		TestListPerformance.run();
		 
		TestSetPerformance.run();
		
		TestMultisetPerformance.run();
		
		TestQueuePerformance.run();
		 
		TestMapPerformance.run();


	}

}
