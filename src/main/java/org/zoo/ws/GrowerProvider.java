package org.zoo.ws;

import javax.xml.ws.Provider;
import javax.xml.transform.Source;

public class GrowerProvider implements Provider<Source> {

	@Override
	public Source invoke(Source message) {
		return message;
	}

}