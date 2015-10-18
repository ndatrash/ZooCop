package org.zoo.ejb;

import javax.ejb.Local;

@Local
public interface Sensor2 {
	boolean turnOn2();
	String connectOn2();	
}