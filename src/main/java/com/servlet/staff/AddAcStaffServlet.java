package com.servlet.staff;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.List;

import com.model.AcademicStaff;
import com.model.Subject;
import com.service.staff.AcademicStaffServiceImpl;
import com.service.subject.SubjectServiceImpl;
import com.util.ImageUtil;

/**
 * Servlet implementation class AddAcStaffServlet
 */
@MultipartConfig
@WebServlet("/add-academic-staff")
public class AddAcStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("admin") == null) {
			response.sendRedirect("admin-login");
		} else {
			List<Subject> subjects = SubjectServiceImpl.getInstance().getAllSubjects();
			request.setAttribute("subjects", subjects);

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/add-academic-staff.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("admin") == null) {
			response.sendRedirect("admin-login");
		} else {
			//Upload Profile Picture
			Part picture =request.getPart("profilePic");
			String profilePic = ImageUtil.uploadStaffProfilePic(picture);
			
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String phoneNumber = request.getParameter("phoneNumber");
			String address = request.getParameter("address");
			String dateOfBirth = request.getParameter("dateOfBirth");
			String bio = request.getParameter("bio");
			int subjectId = Integer.parseInt(request.getParameter("subjectId"));
			String password = request.getParameter("password");
			String role = request.getParameter("role");
			
			//convert date of birth DD-MM-YYYY to YYYY-MM-DD
			String[] dateOfBirthArray = dateOfBirth.split("-");
			String dateOfBirthConverted = dateOfBirthArray[2] + "-" + dateOfBirthArray[1] + "-" + dateOfBirthArray[0];

			AcademicStaff academicStaff = new AcademicStaff(firstName, lastName, email, phoneNumber, address,
					dateOfBirthConverted, bio, profilePic, subjectId, password, role);
			boolean result = AcademicStaffServiceImpl.getInstance().addAcademicStaff(academicStaff);

			if (result) {
				response.sendRedirect("academic-staff?add=success");
			} else {
				response.sendRedirect("academic-staff?add=fail");
			}
		}
	}

}
