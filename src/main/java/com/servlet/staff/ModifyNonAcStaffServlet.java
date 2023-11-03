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

import com.model.NonAcademicStaff;
import com.service.staff.NonAcademicStaffServiceImpl;
import com.util.ImageUtil;

/**
 * Servlet implementation class ModifyNonAcStaffServlet
 */
@MultipartConfig
@WebServlet("/modify-non-academic-staff")
public class ModifyNonAcStaffServlet extends HttpServlet {
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
			int id = Integer.parseInt(request.getParameter("id"));
			NonAcademicStaff nonAcademicStaff = NonAcademicStaffServiceImpl.getInstance().getNonAcademicStaffById(id);
			request.setAttribute("nonAcademicStaff", nonAcademicStaff);

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/modify-non-academic-staff.jsp");
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
			String role = request.getParameter("role");
			
			//convert date of birth DD-MM-YYYY to YYYY-MM-DD
			String[] dateOfBirthArray = dateOfBirth.split("-");
			String dateOfBirthConverted = dateOfBirthArray[2] + "-" + dateOfBirthArray[1] + "-" + dateOfBirthArray[0];


			NonAcademicStaff nonAcademicStaff = new NonAcademicStaff(id, firstName, lastName, email, phoneNumber, address,
					dateOfBirthConverted, bio, profilePic, role);
			boolean isUpdated = NonAcademicStaffServiceImpl.getInstance().updateNonAcademicStaff(nonAcademicStaff);

			if (isUpdated) {
				response.sendRedirect("non-academic-staff?modify=success");
			} else {
				response.sendRedirect("non-academic-staff?modify=fail");
			}
		}
	}

}
