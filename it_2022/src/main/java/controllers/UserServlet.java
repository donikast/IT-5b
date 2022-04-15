package controllers;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import repositories.Repository;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
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
		
		 int id = Integer.parseInt(request.getParameter("id"));
		 User updatedUser = collection.getUserById(id);
		 
		 updatedUser.setPersonalName(request.getParameter("personal_name"));
		 updatedUser.setJobTitle(request.getParameter("job-title"));
		 updatedUser.setDescription(request.getParameter("description"));
		 updatedUser.setEmail(request.getParameter("email"));
		 updatedUser.setPhone(request.getParameter("phone"));
		 updatedUser.getAddress().setStreet(request.getParameter("street"));
		 updatedUser.getAddress().setCity(request.getParameter("city"));
		 
		 for(int i=0;i<updatedUser.getProfSkill().size();i++) {
			 String skillName=request.getParameter("prof-skill-name"+i);
			 updatedUser.getProfSkill().get(i).setSkillName(skillName);
			 int skillValue=Integer.parseInt(request.getParameter("prof-skill-value"+i));
			 updatedUser.getProfSkill().get(i).setSkillValue(skillValue);
		 }
		 
		 for(int j=0;j<updatedUser.getPersonalSkill().size();j++) {
			 String skillName=request.getParameter("personal-skill-name"+j);
			 updatedUser.getPersonalSkill().get(j).setSkillName(skillName);
			 int skillValue=Integer.parseInt(request.getParameter("personal-skill-value"+j));
			 updatedUser.getPersonalSkill().get(j).setSkillValue(skillValue);
		 }

			request.setAttribute("loggedUser", updatedUser);
			RequestDispatcher rd = request.getRequestDispatcher("/ProfilePage.jsp");
			rd.forward(request, response);

		 
	}

}
