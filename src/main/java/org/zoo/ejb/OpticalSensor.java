package org.zoo.ejb;

import javax.ejb.Stateless;
import javax.ejb.EJBContext;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.transaction.UserTransaction;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.*;
import org.zoo.entity.*;
import org.apache.log4j.Logger;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import java.security.Principal;


@Stateless
//@TransactionManagement(TransactionManagementType.BEAN)
public class OpticalSensor implements Sensor {

	//@Resource(name="java:comp/DefaultDataSource")
	//private DataSource derby;
	
	
	@Resource
	private SessionContext context;
	

	private EntityManager em;

	@PersistenceContext(unitName="ZooJPA")
	public void setEntityManager(EntityManager em) { this.em = em; }
	
	@Override
	public boolean turnOn() {
		boolean _ret = false;
		return _ret;
	}
	
	@Override
	@RolesAllowed({"administrator"})
	public String connectOn() {
		String _ret = "OK";
		try {
			Room room = new Room();
			em.persist(room);
			em.flush();
			//Principal p = context.getCallerPrincipal();
			//_ret = "ID = "+room.getRoomId() + " by "+(p != null ? p.getName() : "no user");
		}
		catch(Exception e) {
			_ret = e.getMessage();
			Logger  logger = Logger.getLogger(OpticalSensor.class);
			//logger.setLevel(Logger.INFO);
			logger.error("Got: ", e );
		}
		return _ret;
	}	

}