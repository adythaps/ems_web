package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EmployeeDao;
import model.dto.Employee;
@WebServlet("/view_all_emp")
public class ViewAllEmp extends HttpServlet{
	EmployeeDao d =new EmployeeDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Employee> emps= d.getAllEmployee();
		RequestDispatcher success = req.getRequestDispatcher("view_all_emp.jsp");
		RequestDispatcher fail = req.getRequestDispatcher("admin_operation.jsp");
		
		if(emps!=null) {
			req.setAttribute("employees", emps);
			success.forward(req,resp);
		}
		else {
			req.setAttribute("message", "no entry available");
			fail.forward(req,resp);
		}
	}

}
