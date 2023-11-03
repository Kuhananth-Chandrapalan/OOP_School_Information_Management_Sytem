package com.servlet.staff;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.model.AcademicStaff;
import com.model.Admin;
import com.service.admin.AdminServiceImpl;
import com.service.staff.AcademicStaffServiceImpl;

/**
 * Servlet implementation class AcStaffLoginServlet
 */
@WebServlet("/academic-staff-login")
public class AcStaffLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Check if user is logged in
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("AcademicStaff") == "AcademicStaff") {
			response.sendRedirect("academic-staff-dashboard");
		} else {
			String status = request.getParameter("status");
			if (status == null) {
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/academic-staff-login.jsp");
				rd.forward(request, response);
			} else if (status.equals("wrong")) {
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/academic-staff-login.jsp?status=wrong");
				rd.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		boolean isTrue;

		isTrue = AcademicStaffServiceImpl.getInstance().validateLogin(email, pass);

		if (isTrue == true) {
			HttpSession session = request.getSession();
			AcademicStaff academicStaff = AcademicStaffServiceImpl.getInstance().getAcademicStaffDetails(email);
			int academicStaffId = academicStaff.getStaffId();
			String firstName = academicStaff.getFirstName();
			String lastName = academicStaff.getLastName();
			String emailAdmin = academicStaff.getEmail();

			session.setAttribute("AcademicStaff", "AcademicStaff");
			session.setAttribute("staffId", academicStaffId);
			session.setAttribute("firstName", firstName);
			session.setAttribute("lastName", lastName);
			session.setAttribute("email", emailAdmin);

			response.sendRedirect("academic-staff-login");
		} else {
			response.sendRedirect("academic-staff-login?status=wrong");
		}
	}

}
