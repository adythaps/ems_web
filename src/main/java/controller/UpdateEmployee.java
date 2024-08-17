package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/update_emp")
public class UpdateEmployee extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	int id = Integer.parseInt(req.getParameter("id"));
	String name= req.getParameter("name");
	String password = req.getParameter("password");
	String role =req.getParameter("role");
}
}
