package com.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

		Dog[] dogs = { new Dog("bobik"), new AngryDog("sharik") };

		for (Dog dog : dogs) {
			invokeMethod(dog);
			showClassName(dog);
			showFields(dog);
			showAnnotions(dog);
		}

	}

	private static void invokeMethod(Object object) {
		Class<?> dog = object.getClass();
		Method[] methods = dog.getDeclaredMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(Invoke.class)) {
				try {
					System.out.print("invoking method : " + method.getName() + "   result : ");
					method.invoke(object);
				} catch (Exception e) {

				}
			}
		}
	}

	private static void showClassName(Object object) {
		Class<?> dog = object.getClass();
		System.out.println("class name : " + dog.getSimpleName());

	}

	private static void showFields(Object object) throws IllegalArgumentException, IllegalAccessException {
		Class<?> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			System.out.print("field name : " + field.getName() + " ,");
			System.out.print("field type : " + field.getType() + " ,");
			showModifiers(field);
			System.out.println("field value: " + field.get(object));
		}
	}

	private static void showModifiers(Field field) {
		int modifiers = field.getModifiers();
		System.out.print("field modifiers: ");

		if (Modifier.isFinal(modifiers)) {
			System.out.print("final ");
		}

		if (Modifier.isPrivate(modifiers)) {
			System.out.print("private ");
		}

		if (Modifier.isProtected(modifiers)) {
			System.out.print("protected ");
		}

		if (Modifier.isPublic(modifiers)) {
			System.out.print("public ");
		}

		if (Modifier.isStatic(modifiers)) {
			System.out.print("static ");
		}

		if (Modifier.isTransient(modifiers)) {
			System.out.print("transient ");
		}

		if (Modifier.isVolatile(modifiers)) {
			System.out.print("volatile ");
		}

		System.out.print(",");

	}

	private static void showAnnotions(Object object) {
		Class<?> clazz = object.getClass();
		Annotation[] annotations = clazz.getAnnotations();
		System.out.print("annotations : ");
		for (Annotation annotation : annotations) {
			System.out.print(annotation.toString());
		}
		System.out.println();
	}

}
