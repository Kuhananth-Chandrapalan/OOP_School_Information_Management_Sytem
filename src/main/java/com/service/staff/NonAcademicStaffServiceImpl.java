package com.service.staff;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.model.NonAcademicStaff;
import com.util.DBConnectUtil;

public class NonAcademicStaffServiceImpl implements INonAcademicStaffService {

    public static final Logger log = Logger.getLogger(NonAcademicStaffServiceImpl.class.getName());

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private boolean isSuccess;

    private static NonAcademicStaffServiceImpl instance;

    private NonAcademicStaffServiceImpl() {
    }

    // get instance method for getting the instance of the class
    public static NonAcademicStaffServiceImpl getInstance() {
        if (instance == null)
            instance = new NonAcademicStaffServiceImpl();
        return instance;
    }

    public boolean addNonAcademicStaff(NonAcademicStaff nonAcademicStaff) {
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();

            String firstName = nonAcademicStaff.getFirstName();
            String lastName = nonAcademicStaff.getLastName();
            String email = nonAcademicStaff.getEmail();
            String phoneNumber = nonAcademicStaff.getPhoneNumber();
            String address = nonAcademicStaff.getAddress();
            String dateOfBirth = nonAcademicStaff.getDateOfBirth();
            String role = nonAcademicStaff.getRole();
            String bio = nonAcademicStaff.getBio();
            String profilePic = nonAcademicStaff.getProfilePic();

            String sql = "Insert into Non_Academic_Staff(firstName, lastName, email, phone_number, address, date_of_birth, role, bio, profile_pic) values ('"
                    + firstName + "','" + lastName + "','" + email + "','" + phoneNumber + "','" + address + "','"
                    + dateOfBirth + "','" + role + "','" + bio + "','" + profilePic + "')";
            isSuccess = stmt.executeUpdate(sql) > 0;

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return isSuccess;
    }

    public NonAcademicStaff getNonAcademicStaffById(int id) {
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();
            String sql = "select * from Non_Academic_Staff where non_academic_staff_id='" + id + "'";
            rs = stmt.executeQuery(sql);
            rs.next();

            int straffId = rs.getInt(1);
            String firstName = rs.getString(2);
            String lastName = rs.getString(3);
            String email = rs.getString(4);
            String phoneNumber = rs.getString(5);
            String address = rs.getString(6);
            String dateOfBirth = rs.getString(7);
            String role = rs.getString(8);
            String bio = rs.getString(9);
            String profilePic = rs.getString(10);
            String createdAt = rs.getString(11);
            String updatedAt = rs.getString(12);

            NonAcademicStaff nonAcademicStaff = new NonAcademicStaff(id, firstName, lastName, email, phoneNumber,
                    address, dateOfBirth, role, bio, profilePic, createdAt, updatedAt);

            return nonAcademicStaff;

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    public List<NonAcademicStaff> getAllNonAcademicStaffDetails() {
        ArrayList<NonAcademicStaff> nonAcademicStaffList = new ArrayList<>();
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();
            String sql = "select * from Non_Academic_Staff";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int staffId = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String email = rs.getString(4);
                String phoneNumber = rs.getString(5);
                String address = rs.getString(6);
                String dateOfBirth = rs.getString(7);
                String role = rs.getString(8);
                String bio = rs.getString(9);
                String profilePic = rs.getString(10);
                String createdAt = rs.getString(11);
                String updatedAt = rs.getString(12);

                NonAcademicStaff nonAcademicStaff = new NonAcademicStaff(staffId, firstName, lastName, email,
                        phoneNumber,
                        address, dateOfBirth, bio, profilePic, createdAt, updatedAt, role);

                nonAcademicStaffList.add(nonAcademicStaff);
            }

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return nonAcademicStaffList;
    }

    public boolean updateNonAcademicStaff(NonAcademicStaff nonAcademicStaff) {
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();

            int staffId = nonAcademicStaff.getStaffId();
            String firstName = nonAcademicStaff.getFirstName();
            String lastName = nonAcademicStaff.getLastName();
            String email = nonAcademicStaff.getEmail();
            String phoneNumber = nonAcademicStaff.getPhoneNumber();
            String address = nonAcademicStaff.getAddress();
            String dateOfBirth = nonAcademicStaff.getDateOfBirth();
            String role = nonAcademicStaff.getRole();
            String bio = nonAcademicStaff.getBio();
            String profilePic = nonAcademicStaff.getProfilePic();

            // if profile pic is not updated
            String sql = "";
            if (profilePic == null) {
                sql = "update Non_Academic_Staff set firstName='" + firstName + "', lastName='" + lastName
                        + "', email='" + email + "', phone_number='" + phoneNumber + "', address='" + address
                        + "', date_of_birth='" + dateOfBirth + "', role='" + role + "', bio='" + bio + "' where non_academic_staff_id='"
                        + staffId + "'";
            } else {
                sql = "update Non_Academic_Staff set firstName='" + firstName + "', lastName='" + lastName
                        + "', email='" + email + "', phone_number='" + phoneNumber + "', address='" + address
                        + "', date_of_birth='" + dateOfBirth + "', role='" + role + "', bio='" + bio
                        + "', profile_pic='" + profilePic + "' where non_academic_staff_id='" + staffId + "'";
            }
            isSuccess = stmt.executeUpdate(sql) > 0;

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return isSuccess;
    }

    public boolean deleteNonAcademicStaff(int id) {
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();
            String sql = "delete from Non_Academic_Staff where non_academic_staff_id='" + id + "'";
            isSuccess = stmt.executeUpdate(sql) > 0;

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return isSuccess;
    }
}