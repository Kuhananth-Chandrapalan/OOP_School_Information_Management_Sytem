package com.service.subject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.model.Subject;
import com.util.DBConnectUtil;

public class SubjectServiceImpl implements ISubjectService {

    /** Initialize logger */
    public static final Logger log = Logger.getLogger(SubjectServiceImpl.class.getName());

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private boolean isSuccess;

    private static SubjectServiceImpl instance;

    // private constructor
    private SubjectServiceImpl() {
    }

    // get instance method for getting the instance of the class
    public static SubjectServiceImpl getInstance() {
        if (instance == null)
            instance = new SubjectServiceImpl();
        return instance;
    }

    public boolean addSubject(Subject subject) {
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();

            String subjectName = subject.getSubjectName();
            String description = subject.getDescription();

            String sql = "Insert into Subjects(subject_name, description) values('" + subjectName + "', '" + description
                    + "')";
            isSuccess = stmt.executeUpdate(sql) > 0;

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return isSuccess;
    }

    public Subject getSubjectById(int id) {
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();
            String sql = "select * from Subjects where subject_id=" + id;
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                int subjectId = rs.getInt(1);
                String subjectName = rs.getString(2);
                String description = rs.getString(3);
                String createdAt = rs.getString(4);
                String updatedAt = rs.getString(5);

                Subject subject = new Subject(subjectId, subjectName, description, createdAt, updatedAt);
                return subject;
            }

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    public List<Subject> getAllSubjects() {
        ArrayList<Subject> subjects = new ArrayList<Subject>();
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();
            String sql = "select * from Subjects";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int subjectId = rs.getInt(1);
                String subjectName = rs.getString(2);
                String description = rs.getString(3);
                String createdAt = rs.getString(4);
                String updatedAt = rs.getString(5);

                Subject subject = new Subject(subjectId, subjectName, description, createdAt, updatedAt);
                subjects.add(subject);
            }

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }

        return subjects;
    }

    public boolean updateSubject(Subject subject) {
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();

            int subjectId = subject.getSubjectId();
            String subjectName = subject.getSubjectName();
            String description = subject.getDescription();

            String sql = "Update Subjects set subject_name='" + subjectName + "', description='" + description
                    + "' where subject_id=" + subjectId;
            isSuccess = stmt.executeUpdate(sql) > 0;

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return isSuccess;
    }

    public boolean deleteSubject(int id) {
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();
            String sql = "delete from Subjects where subject_id=" + id;
            isSuccess = stmt.executeUpdate(sql) > 0;

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return isSuccess;
    }

    // Get subjects count
    public int getSubjectsCount() {
        int count = 0;
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();
            String sql = "select count(*) from Subjects";
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return count;
    }
}
