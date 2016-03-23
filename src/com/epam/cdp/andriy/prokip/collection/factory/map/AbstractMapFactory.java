package com.epam.cdp.andriy.prokip.collection.factory.map;

abstract class AbstractMapFactory implements MapFactory {
	
	private String name;

	public AbstractMapFactory(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

}
