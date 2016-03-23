package com.epam.cdp.andriy.prokip.collection.factory.list;

abstract class AbstractListFactory implements ListFactory {

	private String name;

	public AbstractListFactory(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
}
