package com.servlet.exam;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.model.AcademicStaff;
import com.model.ClassX;
import com.model.Exam;
import com.model.Subject;
import com.service.classes.ClassServiceImpl;
import com.service.exam.ExamServiceImpl;
import com.service.staff.AcademicStaffServiceImpl;
import com.service.subject.SubjectServiceImpl;

/**
 * Servlet implementation class ModifySubjectServlet
 */
@WebServlet("/modify-exam")
public class ModifyExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("AcademicStaff") == null) {
			response.sendRedirect("academic-staff-login");
		} else {
			int id = Integer.parseInt(request.getParameter("id"));
			Exam exam = ExamServiceImpl.getInstance().getExamById(id);
			request.setAttribute("exam", exam);

			List<ClassX> classes = ClassServiceImpl.getInstance().getClasses();
			request.setAttribute("classes", classes);
			List<AcademicStaff> academicStaffs = AcademicStaffServiceImpl.getInstance().getAllAcademicStaffDetails();
			request.setAttribute("academicStaffs", academicStaffs);

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/modify-exam.jsp");
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
		if (session == null || session.getAttribute("AcademicStaff") == null) {
			response.sendRedirect("academic-staff-login");
		} else {
			int id = Integer.parseInt(request.getParameter("id"));
			int classId = Integer.parseInt(request.getParameter("classId"));
			int academicStaffId = Integer.parseInt(request.getParameter("academicStaffId"));
			String name = request.getParameter("name");
			Exam exam = new Exam(id, classId, academicStaffId, name);
			boolean result = ExamServiceImpl.getInstance().updateExam(exam);
			if (result) {
				response.sendRedirect("exams?modify=success");
			} else {
				response.sendRedirect("exams?modify=fail");
			}
		}
	}

}
