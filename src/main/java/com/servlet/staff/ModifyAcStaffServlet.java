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
 * Servlet implementation class ModifyAcStaffServlet
 */
@MultipartConfig
@WebServlet("/modify-academic-staff")
public class ModifyAcStaffServlet extends HttpServlet {
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

			int id = Integer.parseInt(request.getParameter("id"));
			AcademicStaff academicStaff = AcademicStaffServiceImpl.getInstance().getAcademicStaffById(id);
			request.setAttribute("academicStaff", academicStaff);

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/modify-academic-staff.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("admin") == null) {
			response.sendRedirect("admin-login");
		} else {
			// Upload Profile Picture
			Part picture = request.getPart("profilePic");
			String profilePic = null;
			// if user upload a new profile picture
			if (picture != null && picture.getSize() > 0) {
				profilePic = ImageUtil.uploadStaffProfilePic(picture);
			}

						
			int id = Integer.parseInt(request.getParameter("id"));
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


			AcademicStaff academicStaff = new AcademicStaff(id, firstName, lastName, email, phoneNumber, address,
					dateOfBirthConverted, bio, profilePic, subjectId, password, role);
			boolean isUpdated = AcademicStaffServiceImpl.getInstance().updateAcademicStaff(academicStaff);

			if (isUpdated) {
				response.sendRedirect("academic-staff?modify=success");
			} else {
				response.sendRedirect("academic-staff?modify=fail");
			}
		}
	}

}
