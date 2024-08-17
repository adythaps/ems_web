package model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import model.dto.Employee;

public class EmployeeDao {
	FileInputStream fis;
	Properties property=new Properties(); 
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Statement stm;
	{
		try {
			fis = new FileInputStream("D:\\QSpider\\JAVA-advance\\servlet\\ems_web\\src\\main\\resources\\data.properties");
			property.load(fis);
			String url= property.getProperty("url");
			
//		load the driver
			String driver=property.getProperty("driver");
			Class.forName(driver);
			System.out.println("driver loaded");

			
//		establish connection
			con=DriverManager.getConnection(url,property);
			System.out.println("Connection done");
//			step 3 statement
			stm=con.createStatement();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public static void main(String[] args) {
		
//*************adminValidate**************************
//		EmployeeDao d=new EmployeeDao();
//		Employee e=new Employee();
//		
//		e.setId(100);
//		e.setPassword("adi20001");
//		int id=100;
//		System.out.println(d.adminValidate(e));
		
//****************addEmployee************************	
//		EmployeeDao d=new EmployeeDao();
//		Employee e=new Employee("maina",400000.00,8558247569L,"maina1234","hr");
//		System.out.println(d.addEmployee(e));
		
//****************getEmployeeById************************		
//			EmployeeDao d=new EmployeeDao();
//			int id=100;
//			Employee emp=d.getEmployeeById(id);
//			if(emp!=null) {
//				System.out.println("ID:"+emp.getId()+" NAME:"+emp.getName()+" SALARY:"+emp.getSalary()+" PHONE NO:"+emp.getPhone()+" PASSWORD:"+emp.getPassword()+" ROLE:"+emp.getRole());
//			}
//			else {
//				System.out.println("not found");
//			}
						
//*************getAllEmployee*********************************
//		EmployeeDao d=new EmployeeDao();
//		
//		List<Employee> emp=d.getAllEmployee();
//		
//		for(Employee e:emp) {
//			System.out.println(e.getId()+" "+e.getName()+" "+e.getPassword()+" "+e.getRole());
//			
//		}
		
//*************getAllEmployee*********************************
//		EmployeeDao d=new EmployeeDao();
//		System.out.println(d.removeEmployee(2));
		
//*************UpdateEmployee*********************************
//		EmployeeDao d=new EmployeeDao();
//		Employee e=new Employee(1,"mohan",600000,6523587742L,"mohan1234","HR");
//
//		Employee e=new Employee(1,"mohan",600000.00,6523587742L,"mohan1234","HR");
//		System.out.println(d.UopdateEmployee(e));
	
	
	}
	
	
	
	
	public boolean adminValidate(Employee emp){
		String query = "select password, role from employee where id = ? ";
		try {
			
			ps=con.prepareStatement(query);
			ps.setInt(1,emp.getId());

			rs = ps.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(emp.getPassword()) && rs.getString(2).equalsIgnoreCase("admin"))
				return true;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	return false;
	}
	
	public boolean addEmployee(Employee emp) {
		String query="insert into employee(name,salary,phone,password,role)values(?,?,?,?,?)";
		
		try {
			ps=con.prepareStatement(query);
			
			ps.setString(1, emp.getName());
			ps.setDouble(2, emp.getSalary());
			ps.setLong(3, emp.getPhone());
			ps.setString(4, emp.getPassword());
			ps.setString(5, emp.getRole());

			if(ps.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	

	public Employee getEmployeeById(int id) {
		
		String query="select* from employee where id=?";
		
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				return new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getLong(4),rs.getString(5),rs.getString(6));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public List<Employee> getAllEmployee(){
		List<Employee> emp= new ArrayList<>();
		String query="select * from employee";
		
		try {
			rs=stm.executeQuery(query);
			if(rs.next()) {
				do {
					emp.add(new Employee(rs.getInt("id"),rs.getString("name"),rs.getDouble("salary"),rs.getLong("phone"),rs.getString("password"),rs.getString("role")));
				}
				while(rs.next());
				return emp;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Boolean removeEmployee(int id) {
		String query="delete from employee where id=?";
		
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, id);
			if(ps.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Boolean UopdateEmployee(Employee emp) {
		String query ="Update employee set name=? , salary=? , phone=? , password=? , role=? where id=?";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, emp.getName());
			ps.setDouble(2, emp.getSalary());
			ps.setLong(3, emp.getPhone());
			ps.setString(4, emp.getName());
			ps.setString(5, emp.getName());
			ps.setInt(6, emp.getId());
			if(ps.executeUpdate()>0) {
				return true;
			}
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return false;	
	}
	
}
