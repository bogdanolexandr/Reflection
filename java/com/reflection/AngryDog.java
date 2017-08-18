package com.reflection;

public class AngryDog extends Dog {

	public AngryDog(String name) {
		super(name);
	}

	@Invoke
	public void bark() {
		System.out.println("angry bark bark");
	}

	@Override
	public String toString() {
		return "Angry" + super.toString();
	}

}
