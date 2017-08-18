package com.reflection;

public class DogProxy implements Barkable {

	private Barkable barkable;

	public DogProxy(Barkable barkable) {
		this.barkable = barkable;
	}

	@Override
	public void bark() {
		barkable.bark();
	}

	@Override
	public void setName(String name) throws ImmutableException {
		throw new ImmutableException();
	}

	@Override
	public String getName() {
		return barkable.getName();
	}

}
