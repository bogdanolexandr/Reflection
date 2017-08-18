package com.reflection;

import static org.junit.Assert.*;

import org.junit.Test;

public class DogProxyTest {

	private Barkable dog = new Dog("sharik");

	@Test(expected = ImmutableException.class)
	public void testSetName() {
		dog = new DogProxy(dog);
		dog.setName("bobik");
	}

	@Test
	public void testGetName() {
		dog = new DogProxy(dog);
		String expected = "sharik";
		String actual = dog.getName();
		assertEquals(expected, actual);
	}

}
