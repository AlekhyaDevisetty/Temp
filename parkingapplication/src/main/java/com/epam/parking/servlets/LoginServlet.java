package com.epam.parking.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.parking.service.Admin;
import com.epan.parking.dao.ConsoleDAO;
import com.epan.parking.dao.DAO;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		      
		      // Set response content type
		      response.setContentType("text/html");
		      DAO dao = new ConsoleDAO();
				int totalSlots = dao.initializeSlotSize(40);
		      Admin check = new Admin();
		      PrintWriter out = response.getWriter();
		      String n=request.getParameter("name");  
		      String p=request.getParameter("password"); 
		      if(check.match(n,p)) {
		    	  RequestDispatcher rd=request.getRequestDispatcher("Menu.html");  
		          rd.forward(request,response);  
		      }
		      else {
		    	  out.write("Login Failed");
		      }
		      
		   }

		   // Method to handle POST method request.
		   public void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {

		      doGet(request, response);
		   }

}

