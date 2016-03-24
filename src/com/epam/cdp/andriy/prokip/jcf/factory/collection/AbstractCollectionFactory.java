package com.epam.cdp.andriy.prokip.jcf.factory.collection;

abstract class AbstractCollectionFactory implements CollectionFactory {

	private String name;

	public AbstractCollectionFactory(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
}
