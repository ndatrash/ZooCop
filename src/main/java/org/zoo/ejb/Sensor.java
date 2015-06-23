package org.zoo.ejb;

import javax.ejb.Local;

@Local
public interface Sensor {
	boolean turnOn();
	String connectOn();	
}