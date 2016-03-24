package com.epam.cdp.andriy.prokip.jcf.factory.collection;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.PriorityQueue;

public class QueueFactoryImpl {
	
	public static CollectionFactory PRIORITY_QUEUE_FACTORY = new AbstractCollectionFactory("ProirityQueue") {
		
		@Override
		public Collection<String> create(int capacity) {
			return new PriorityQueue<String>();
		}
	};
	
	public static CollectionFactory PRIORITY_QUEUE_WITH_SIZE_FACTORY = 
			new AbstractCollectionFactory("ProirityQueue with init size") {
		
		@Override
		public Collection<String> create(int capacity) {
			return new PriorityQueue<String>(capacity);
		}
	};
	
	public static CollectionFactory ARRAY_DEQUEUE_FACTORY = 
			new AbstractCollectionFactory("ArrayDequeue") {
		
		@Override
		public Collection<String> create(int capacity) {
			return new ArrayDeque<String>();
		}
	};
	
	public static CollectionFactory ARRAY_DEQUEUE_WITH_SIZE_FACTORY = 
			new AbstractCollectionFactory("ArrayDequeue with init size") {
		
		@Override
		public Collection<String> create(int capacity) {
			return new ArrayDeque<String>(capacity);
		}
	};
	
}
