
package com.service.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.model.Student;
import com.util.DBConnectUtil;

public class StudentServiceImpl implements IStudentService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(StudentServiceImpl.class.getName());

	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private boolean isSuccess;

	private static StudentServiceImpl instance;

	// private constructor
	private StudentServiceImpl() {
	}

	// get instance method for getting the instance of the class
	public static StudentServiceImpl getInstance() {
		if (instance == null)
			instance = new StudentServiceImpl();
		return instance;
	}

	public boolean validateLogin(String email, String pass) {
		try {
			con = DBConnectUtil.getConnection();
			stmt = con.createStatement();
			String sql = "select * from Students where email='" + email + "' and password='" + pass + "'";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		}

		return isSuccess;
	}

	@Override
	public boolean addStudent(Student student) {
		try {
			con = DBConnectUtil.getConnection();
			stmt = con.createStatement();

			int classId = student.getClassId();
			String firstName = student.getFirstName();
			String lastName = student.getLastName();
			String email = student.getEmail();
			String phoneNumber = student.getPhoneNumber();
			String password = student.getPassword();
			String address = student.getAddress();
			String dateOfBirth = student.getDateOfBirth();
			String gender = student.getGender();
			String bio = student.getBio();
			String profilePic = student.getProfilePic();

			String sql = "Insert into Students(class_id, firstName, lastName, email, phone_number, password, address, date_of_birth, gender, bio, profile_pic) values ('"
					+ classId + "', '" + firstName + "', '" + lastName + "', '" + email + "', '" + phoneNumber + "', '"
					+ password + "', '" + address + "', '"
					+ dateOfBirth + "', '" + gender + "', '" + bio + "', '" + profilePic + "');";
			isSuccess = stmt.executeUpdate(sql) > 0;

		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		return isSuccess;
	}

	@Override
	public Student getStudentById(int id) {
		try {
			con = DBConnectUtil.getConnection();
			stmt = con.createStatement();
			String sql = "select * from Students where student_id='" + id + "';";
			rs = stmt.executeQuery(sql);
			rs.next();

			int studentId = rs.getInt(1);
			int classId = rs.getInt(2);
			String firstName = rs.getString(3);
			String lastName = rs.getString(4);
			String email = rs.getString(5);
			String phoneNumber = rs.getString(6);
			String password = rs.getString(7);
			String address = rs.getString(8);
			String dateOfBirth = rs.getString(9);
			String gender = rs.getString(10);
			String bio = rs.getString(11);
			String profilePic = rs.getString(12);
			String createdAt = rs.getString(13);
			String updatedAt = rs.getString(14);

			Student student = new Student(studentId, classId, firstName, lastName, email, phoneNumber, password,
					address, dateOfBirth, gender, bio, profilePic, createdAt, updatedAt);

			return student;

		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		return null;
	}

	@Override
	public List<Student> getAllStudentDetails() {
		ArrayList<Student> students = new ArrayList<>();
		try {
			con = DBConnectUtil.getConnection();
			stmt = con.createStatement();
			String sql = "select * from Students";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				int studentId = rs.getInt(1);
				int classId = rs.getInt(2);
				String firstName = rs.getString(3);
				String lastName = rs.getString(4);
				String email = rs.getString(5);
				String phoneNumber = rs.getString(6);
				String address = rs.getString(8);
				String dateOfBirth = rs.getString(9);
				String gender = rs.getString(10);
				String bio = rs.getString(11);
				String profilePic = rs.getString(12);
				String createdAt = rs.getString(13);
				String updatedAt = rs.getString(14);

				Student student = new Student(studentId, classId, firstName, lastName, email, phoneNumber, address,
						dateOfBirth, gender, bio, profilePic, createdAt, updatedAt);
				students.add(student);
			}

		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		return students;
	}

	@Override
	public boolean updateStudent(Student student) {
		try {

			con = DBConnectUtil.getConnection();
			stmt = con.createStatement();

			int studentId = student.getStudentId();
			int classId = student.getClassId();
			String firstName = student.getFirstName();
			String lastName = student.getLastName();
			String email = student.getEmail();
			String phoneNumber = student.getPhoneNumber();
			String password = student.getPassword();
			String address = student.getAddress();
			String dateOfBirth = student.getDateOfBirth();
			String gender = student.getGender();
			String bio = student.getBio();
			String profilePic = student.getProfilePic();

			// if profile pic is not updated
			String sql = "";
			if (profilePic == null) {
				sql = "update Non_Academic_Staff set class_id='" + classId + "', firstName='" + firstName
						+ "', lastName='" + lastName + "', email='" + email + "', phone_number='" + phoneNumber
						+ "', password='" + password + "',"
						+ "address='" + address + "',date_of_birth='" + dateOfBirth + "', gender='" + gender
						+ "', bio='" + bio + "'" + " where student_id=" + studentId
						+ ";";
			} else {
				sql = "update Students set class_id='" + classId + "', firstName='" + firstName
						+ "', lastName='" + lastName + "', email='" + email + "', phone_number='" + phoneNumber
						+ "', password='" + password + "',"
						+ "address='" + address + "',date_of_birth='" + dateOfBirth + "', gender='" + gender
						+ "', bio='" + bio + "', profile_pic='" + profilePic + "'" + " where student_id=" + studentId
						+ ";";

			}
			isSuccess = stmt.executeUpdate(sql) > 0;

		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		return isSuccess;
	}

	@Override
	public boolean deleteStudent(int id) {
		try {
			con = DBConnectUtil.getConnection();
			stmt = con.createStatement();
			String sql = "DELETE FROM Students WHERE student_id = " + id + ";";
			isSuccess = stmt.executeUpdate(sql) > 0;
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		return isSuccess;
	}

	// Get students count
	public int getStudentsCount() {
		int count = 0;
		try {
			con = DBConnectUtil.getConnection();
			stmt = con.createStatement();
			String sql = "select count(*) from Students";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		return count;
	}

}
