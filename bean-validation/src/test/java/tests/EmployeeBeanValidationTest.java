package tests;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Test;
import entities.Employee;

//###################################
//javax.validation is specification of JSR303. YOu need an implementation of that JSR303.
//You have to add an implementation of that specification in your pom. 
//You can add hibernate-validator
//####################################
// hibernate-validator also required Expression Language
// Add Implementation of expression language in to your POM. org.glassfish has a javax.el implementation.
// Upi can add javax.el from glassFish

public class EmployeeBeanValidationTest {

	//#######################################
	//Some frameworks – such as Spring – have simple ways of triggering the validation process by just using annotations. 
	//This is mainly so that we don’t have to interact with the programmatic validation API.
	// Here is the example of Programmatic validation
	//###########################################
	@Test
	public void employeeBeanTest() {
		
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
			
			
			//Defining a bean that i want to validate
			Employee employee1 = new Employee();
			employee1.setName(null);
			employee1.setDepartment("IT");
			employee1.setSalary(155);
			employee1.setTitle("Developer");
			
			
			
			//Validating the bean
			//Now that we have a Validator, we can validate our bean by passing it to the validate method. 
			//Any violations of the constraints defined in the User object will be returned as a Set.
			
			Set<ConstraintViolation<Employee>> violations = validator.validate(employee1);
			
			
			
			//By iterating over the violations, we can get all the violation messages by using the getMessage method.
			for(ConstraintViolation<Employee> viloation : violations) {
				System.out.println(viloation.getMessage());
			}
			
	}
}
