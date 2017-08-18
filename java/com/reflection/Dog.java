package com.reflection;

@AnnotationForClass
public class Dog implements Barkable {

	private transient String name;

	public Dog(String name) {
		this.name = name;
	}

	@Invoke
	public void bark() {
		System.out.println("bark bark");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dog " + name;
	}

}
