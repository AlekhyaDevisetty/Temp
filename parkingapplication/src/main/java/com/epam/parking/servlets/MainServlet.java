package com.epam.parking.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.epam.parking.bean.VehicleBean;
import com.epam.parking.service.ParkingService;
import com.epam.parking.service.UnparkingService;
import com.epan.parking.dao.ConsoleDAO;
import com.epan.parking.dao.DAO;
import com.epan.parking.dao.DatabaseDao;
import com.epan.parking.dao.FileDAO;

@WebServlet(urlPatterns = "/MainServlet")
public class MainServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Instance variable slot.
	 */
	int slot = 0;

	/**
	 * Post method of the servlet.
	 * 
	 * @param HTTPServletRequest.
	 * @param HTTPServletResponse.
	 * @throws IOException.
	 * @throws ServletException.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String requirement = request.getParameter("requirement");
		String vehicleNumber = request.getParameter("vehicleNumber");
		DAO dao = new FileDAO();
		
			if (requirement.equals("parking")) {
				ParkingService ps = new ParkingService();
				int slotNumber = ps.parkVehicle(vehicleNumber, dao);
				System.out.println(slotNumber);
				RequestDispatcher rd = request.getRequestDispatcher("/Menu.html");
				rd.include(request, response);
				
			}

			else if (requirement.equals("unparking")) {
			UnparkingService ups = new UnparkingService();
			int slotNumber = ups.unparkVehicle(vehicleNumber, dao);
			RequestDispatcher rd = request.getRequestDispatcher("/Menu.html");
			rd.include(request, response);
			
			
		}
			else if(requirement.equals("display")) {
				out.println(VehicleBean.getVehicles());
			}

	}

}
