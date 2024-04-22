package App;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ejbs.Calculation;

@Stateless
@Path("calc")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class UserService {
	
	
	@PersistenceContext(unitName="calc")
	private EntityManager entityManager;
	
	@POST
	@Path("performCalc")
	public int createCalculation(Calculation calculation)
	{
		
		if (calculation.getoperation().equals("+")) 
		{
		    calculation.setResult(calculation.getNumber1() + calculation.getNumber2());
		    entityManager.persist(calculation);
		    return calculation.getResult();
		} 
		
		else if (calculation.getoperation().equals("-")) 
		{
			calculation.setResult(calculation.getNumber1() - calculation.getNumber2());
			entityManager.persist(calculation);
		    return calculation.getResult();
		} 
		
		else if (calculation.getoperation().equals("*")) 
		{
			calculation.setResult(calculation.getNumber1() * calculation.getNumber2());
			entityManager.persist(calculation);
		    return calculation.getResult();
		}
		
		else if (calculation.getoperation().equals("/")) 
		{
			calculation.setResult(calculation.getNumber1() / calculation.getNumber2());
			entityManager.persist(calculation);
		    return calculation.getResult();
		}
		
		else 
			return 0;
		
	}
	
	
	
	@GET 
	@Path("calculations")
	public List<Calculation>  getCalculations() {
		TypedQuery<Calculation> query = entityManager.createQuery("SELECT c FROM Calculation c", Calculation.class);
		List<Calculation> operations = query.getResultList();
		return operations;
	}
	
	
	@GET
	 @Path("test")
	 public String test() {
		return "test from calc ";
	}

}


