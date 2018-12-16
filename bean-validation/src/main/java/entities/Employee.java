package entities;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

//###################################
//Property level validation
//##################################
public class Employee {

	
	@NotNull(message="Name can not be null")
	private String name;
	
	@NotNull(message="department cannot be null")
	private String department;
	
	@Min(value =0, message = "Can not be $0 per hour")
	@Max(value=150,message="Can not be more than $150 per hour")
	private double salary;
	

	//no validation
	private String title;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", salary=" + salary + ", title=" + title
				+ "]";
	}
	
	
}
