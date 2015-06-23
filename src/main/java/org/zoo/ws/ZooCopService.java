package org.zoo.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public class ZooCopService {

	@WebMethod
	public String instantiate(String name) {
		return name+" is created";
	}

}
