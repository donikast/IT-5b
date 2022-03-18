package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import repositories.Repository;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Repository collection;

	public void init(ServletConfig config) throws ServletException {
		collection = Repository.getInstance();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String personalName = request.getParameter("personal-name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repeatRassword = request.getParameter("repeat-password");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(personalName==null || personalName.isEmpty() || username==null || username.isEmpty() ||
				password==null || password.isEmpty() || !password.equals(repeatRassword)) {
			out.print("<html><body><p>Не са попълнени всички полета или паролите не съвпадат!</p></body></html>");
		}
		else {
			User user = new User(personalName, username, password);
			if(collection.addUser(user)) {
				out.print("<html><body><p>Успешно регистриран потребител!</p></body></html>");
			}
			else {
				out.print("<html><body><p>Потребителското име е заето!</p></body></html>");
			}
			
		}
		
	}
	
	
	
	
	
	
	
	

}
