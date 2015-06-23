package org.zoo.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import org.zoo.ejb.Sensor;
import com.sun.appserv.security.ProgrammaticLogin;
//import org.glassfish.api.embedded.EmbeddedFileSystem;
//import java.io.File;
import java.util.HashMap;
import java.util.Map;

//@Ignore
public class ElementaryTest {

	static EJBContainer ejbContainer;
	static Context ctx;
	//static Server server;
	
	@BeforeClass
	public static void before() {
	
		Map<String, Object> properties = new HashMap<>();
		properties.put("org.glassfish.ejb.embedded.glassfish.installation.root", 
		"C:/Users/SBT-Nikiforov-DA/glassfish-4.1");	
		properties.put("org.glassfish.ejb.embedded.glassfish.configuration.file", 
		"C:/Users/SBT-Nikiforov-DA/glassfish-4.1/glassfish4/glassfish/domains/domain1/config/domain.xml");		
		properties.put("org.glassfish.ejb.embedded.glassfish.instance.root", 
		"C:/Users/SBT-Nikiforov-DA/glassfish-4.1/glassfish4/glassfish/domains/domain1");			
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}

	
	@Test
	public void simpleCall() throws Exception {
		
		Sensor s = (Sensor)ctx.lookup("java:global/classes/OpticalSensor");
		ProgrammaticLogin pgLogin = new ProgrammaticLogin();
        pgLogin.login("zoocopadmin", "zoocopadmin", "file", true);
		System.out.println(s.connectOn());
		
	}

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        try {
            if (ctx != null) {
                ctx.close();
            }
        } catch (NamingException ex) {
            // handle error
        }
        if (ejbContainer != null) {
            ejbContainer.close();
        }
    }	
	
}