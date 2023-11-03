package com.servlet.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.model.Admin;
import com.service.admin.AdminServiceImpl;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin-login")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Check if user is logged in
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("admin") == "admin") {
			response.sendRedirect("/admin-dashboard");
		} else {
			String status = request.getParameter("status");
			if (status == null) {
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/admin-login.jsp");
				rd.forward(request, response);
			} else if (status.equals("wrong")) {
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/admin-login.jsp?status=wrong");
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

		isTrue = AdminServiceImpl.getInstance().validateLogin(email, pass);

		if (isTrue == true) {
			HttpSession session = request.getSession();
			Admin admin = AdminServiceImpl.getInstance().getAdminDetails(email);
			int adminId = admin.getAdminId();
			String firstName = admin.getFirstName();
			String lastName = admin.getLastName();
			String emailAdmin = admin.getEmail();

			session.setAttribute("admin", "admin");
			session.setAttribute("adminId", adminId);
			session.setAttribute("firstName", firstName);
			session.setAttribute("lastName", lastName);
			session.setAttribute("email", emailAdmin);

			response.sendRedirect("admin-dashboard");
		} else {
			response.sendRedirect("admin-login?status=wrong");
		}
	}
}
