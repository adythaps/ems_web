package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EmployeeDao;
@WebServlet("/remove_emp")
public class RemoveEmployee extends HttpServlet{
	EmployeeDao d=new EmployeeDao(); 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	    String idParam = req.getParameter("id");

		   if (idParam == null || idParam.isEmpty()) {
		        req.setAttribute("message", "Invalid Employee ID");
		        RequestDispatcher rd = req.getRequestDispatcher("view_all_emp.jsp");
		        rd.forward(req, resp);
		        return;
		    }
		
		Integer id=Integer.parseInt(req.getParameter("id"));
		
		RequestDispatcher rd =req.getRequestDispatcher("view_all_emp.jsp");
		if(d.removeEmployee(id)) {
			req.setAttribute("message", "Emp removed");
			rd.forward(req, resp);
		}
		else {
			req.setAttribute("message", "failed to remove");
			rd.forward(req, resp);
		}

	}
}
