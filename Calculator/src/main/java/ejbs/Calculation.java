package ejbs;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Stateless
@Entity
public class Calculation 

{	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int operationNumber;
	private int number1;
	private int number2;
	private String operation;
	private int result;
	
	public Calculation()
	{}
	
	public Calculation(int number1, int number2, String operation) {
		this.number1 = number1;
		this.number2 = number2;
		this.operation = operation;
	}
	public void setNumber1(int number1) {
		this.number1 = number1;
	}
	public int getNumber2() {
		return number2;
	}
	public void setNumber2(int number2) {
		this.number2 = number2;
	}
	public String getoperation() {
		return operation;
	}
	
	public int getNumber1() {
		return number1;
	}
	public void setoperation(String operation) {
		this.operation = operation;
		
	}

	public int getOperationNumber() {
		return operationNumber;
	}

	public void setOperationNumber(int operationNumber) {
		this.operationNumber = operationNumber;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	
	
	
}
