package org.zoo.test;

import org.junit.*;

public class Mung {
	@Test(expected=NullPointerException.class) 
	public void message() {
		String x = null;
		x.toCharArray();
		System.out.println("Mung message");
	}
}