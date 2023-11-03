package com.service.staff;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.model.AcademicStaff;
import com.model.Admin;
import com.util.DBConnectUtil;

public class AcademicStaffServiceImpl implements IAcademicStaffService {

    public static final Logger log = Logger.getLogger(AcademicStaffServiceImpl.class.getName());

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private boolean isSuccess;

    private static AcademicStaffServiceImpl instance;

    private AcademicStaffServiceImpl() {
    }

    // get instance method for getting the instance of the class
    public static AcademicStaffServiceImpl getInstance() {
        if (instance == null)
            instance = new AcademicStaffServiceImpl();
        return instance;
    }

    public boolean validateLogin(String email, String pass) {
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();
            String sql = "select * from Academic_Staff where email='" + email + "' and password='" + pass + "'";
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

    public boolean addAcademicStaff(AcademicStaff AcademicStaff) {
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();

            int subjectId = AcademicStaff.getSubjectId();
            String firstName = AcademicStaff.getFirstName();
            String lastName = AcademicStaff.getLastName();
            String dateOfBirth = AcademicStaff.getDateOfBirth();
            String email = AcademicStaff.getEmail();
            String password = AcademicStaff.getPassword();
            String phoneNumber = AcademicStaff.getPhoneNumber();
            String address = AcademicStaff.getAddress();
            String role = AcademicStaff.getRole();
            String bio = AcademicStaff.getBio();
            String profilePic = AcademicStaff.getProfilePic();

            String sql = "Insert into Academic_Staff(subject_id, firstName, lastName, date_of_birth, email, password, phone_number, address, role, bio, profile_Pic) values ('"
                    + subjectId + "','" + firstName + "','" + lastName + "','" + dateOfBirth + "','" + email + "','"
                    + password + "','" + phoneNumber + "','" + address + "','" + role + "','" + bio + "','" + profilePic
                    + "')";
            isSuccess = stmt.executeUpdate(sql) > 0;

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return isSuccess;
    }

    public AcademicStaff getAcademicStaffById(int id) {
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();
            String sql = "select * from Academic_Staff where academic_staff_id=" + id;
            rs = stmt.executeQuery(sql);
            rs.next();

            int subjectId = rs.getInt(2);
            String firstName = rs.getString(3);
            String lastName = rs.getString(4);
            String dateOfBirth = rs.getString(5);
            String email = rs.getString(6);
            String phoneNumber = rs.getString(8);
            String address = rs.getString(9);
            String role = rs.getString(10);
            String bio = rs.getString(11);
            String profilePic = rs.getString(12);
            String createdAT = rs.getString(13);
            String updatedAT = rs.getString(14);

            AcademicStaff AcademicStaff = new AcademicStaff(id, firstName, lastName, email, phoneNumber, address,
                    dateOfBirth, bio, profilePic, createdAT, updatedAT, subjectId, role);
            return AcademicStaff;

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    public List<AcademicStaff> getAllAcademicStaffDetails() {
        ArrayList<AcademicStaff> AcademicStaffList = new ArrayList<AcademicStaff>();

        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();
            String sql = "select * from Academic_Staff";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int staffId = rs.getInt(1);
                int subjectId = rs.getInt(2);
                String firstName = rs.getString(3);
                String lastName = rs.getString(4);
                String dateOfBirth = rs.getString(5);
                String email = rs.getString(6);
                String phoneNumber = rs.getString(8);
                String address = rs.getString(9);
                String role = rs.getString(10);
                String bio = rs.getString(11);
                String profilePic = rs.getString(12);
                String createdAT = rs.getString(13);
                String updatedAT = rs.getString(14);

                AcademicStaff AcademicStaff = new AcademicStaff(staffId, firstName, lastName, email, phoneNumber,
                        address, dateOfBirth, bio, profilePic, createdAT, updatedAT, subjectId, role);

                AcademicStaffList.add(AcademicStaff);
            }

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return AcademicStaffList;
    }

    public boolean updateAcademicStaff(AcademicStaff AcademicStaff) {
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();

            int staffId = AcademicStaff.getStaffId();
            int subjectId = AcademicStaff.getSubjectId();
            String firstName = AcademicStaff.getFirstName();
            String lastName = AcademicStaff.getLastName();
            String dateOfBirth = AcademicStaff.getDateOfBirth();
            String email = AcademicStaff.getEmail();
            String password = AcademicStaff.getPassword();
            String phoneNumber = AcademicStaff.getPhoneNumber();
            String address = AcademicStaff.getAddress();
            String role = AcademicStaff.getRole();
            String bio = AcademicStaff.getBio();
            String profilePic = AcademicStaff.getProfilePic();

            // if profile pic is not updated
            String sql = "";
            if (profilePic == null) {
                sql = "update Academic_Staff set subject_Id='" + subjectId + "', firstName='" + firstName
                        + "', lastName='" + lastName + "', date_Of_Birth='" + dateOfBirth + "', email='" + email
                        + "', password='" + password + "', phone_Number='" + phoneNumber + "', address='" + address
                        + "', role='" + role + "', bio='" + bio + "' where academic_staff_id=" + staffId;
            } else {
                sql = "update Academic_Staff set subject_Id='" + subjectId + "', firstName='" + firstName
                        + "', lastName='" + lastName + "', date_Of_Birth='" + dateOfBirth + "', email='" + email
                        + "', password='" + password + "', phone_Number='" + phoneNumber + "', address='" + address
                        + "', role='" + role + "', bio='" + bio + "', profile_Pic='" + profilePic
                        + "' where academic_staff_id=" + staffId;
            }
            isSuccess = stmt.executeUpdate(sql) > 0;

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return isSuccess;
    }

    public boolean deleteAcademicStaff(int id) {
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();
            String sql = "delete from Academic_Staff where academic_staff_id=" + id;
            isSuccess = stmt.executeUpdate(sql) > 0;

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return isSuccess;
    }

    // get teachers by count
    public int getAcademicStaffCount() {
        int count = 0;
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();
            String sql = "select count(*) from Academic_Staff";
            rs = stmt.executeQuery(sql);
            rs.next();
            count = rs.getInt(1);

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return count;
    }

	public AcademicStaff getAcademicStaffDetails(String iEmail) {
		try {
			con = DBConnectUtil.getConnection();
			stmt = con.createStatement();
			String sql = "select * from Academic_Staff where email='"+iEmail+"';";
			rs = stmt.executeQuery(sql);
			rs.next();
			
			int id = rs.getInt(1);
			int subjectId = rs.getInt(2);
            String firstName = rs.getString(3);
            String lastName = rs.getString(4);
            String dateOfBirth = rs.getString(5);
            String email = rs.getString(6);
            String phoneNumber = rs.getString(8);
            String address = rs.getString(9);
            String role = rs.getString(10);
            String bio = rs.getString(11);
            String profilePic = rs.getString(12);
            String createdAT = rs.getString(13);
            String updatedAT = rs.getString(14);

            AcademicStaff AcademicStaff = new AcademicStaff(id, firstName, lastName, email, phoneNumber, address,
                    dateOfBirth, bio, profilePic, createdAT, updatedAT, subjectId, role);
            return AcademicStaff;
			
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
    	}
		return null;
	}
}
