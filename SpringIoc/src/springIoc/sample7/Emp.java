package springIoc.sample7;

public class Emp {
	
	private String name;
	private int salary;
	
	public Emp() {
		
	}
	
	public Emp(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
