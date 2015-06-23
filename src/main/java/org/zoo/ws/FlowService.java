package org.zoo.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public class FlowService {

	@WebMethod
	public String instantiate(String name) {
		return name+" is flowed";
	}

}