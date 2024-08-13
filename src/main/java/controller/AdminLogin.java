package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.EmployeeDao;
import model.dto.Employee;
@WebServlet("/Admin_Login")
public class AdminLogin extends HttpServlet{
	EmployeeDao d= new EmployeeDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id= Integer.parseInt(req.getParameter("id"));
		String Pass= req.getParameter("password");
		Employee e= new Employee();
		e.setId(id);
		e.setPassword(Pass);
		
		RequestDispatcher success = req.getRequestDispatcher("admin_operation.jsp");
		RequestDispatcher fail = req.getRequestDispatcher("Admin_Login.jsp");
		if(d.adminValidate(e)) {
			HttpSession session = req.getSession();
			session.setAttribute("admin", e);
			req.setAttribute("message", "Admin login success");
			success.forward(req, resp);
		}
		else {
			req.setAttribute("message", "Admin login failed");
			fail.forward(req, resp);
		}
	}

}
