package model.dto;

public class Employee {
	
	private int id;
	private String name;
	private Double salary;
	private Long phone;
	private String password;
	private String role;
	
	public Employee() {
	}
	
	public Employee(int id, String name, Double salary, Long phone, String password, String role) {
		this(name,salary,phone,password,role);
		this.id = id;
	}

	public Employee( String name, Double salary, Long phone, String password, String role) {
		super();
		this.name = name;
		this.salary = salary;
		this.phone = phone;
		this.password = password;
		this.role = role;
	}
	
//	Getters & Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
