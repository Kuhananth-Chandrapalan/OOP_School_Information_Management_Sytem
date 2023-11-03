package com.service.exam;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.model.Exam;
import com.util.DBConnectUtil;

public class ExamServiceImpl implements IExamService {

    /** Initialize logger */
    public static final Logger log = Logger.getLogger(ExamServiceImpl.class.getName());

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private boolean isSuccess;

    private static ExamServiceImpl instance;

    // private constructor
    private ExamServiceImpl() {
    }

    // get instance method for getting the instance of the class
    public static ExamServiceImpl getInstance() {
        if (instance == null)
            instance = new ExamServiceImpl();
        return instance;
    }

    @Override
    public boolean addExam(Exam exam) {
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();

            int classId = exam.getClassId();
            int academicStaffId = exam.getAcademicStaffId();
            String examName = exam.getExamName();

            String sql = "Insert into Exams(class_id, academic_staff_id, exam_name) values('" + classId + "', '"
                    + academicStaffId + "', '" + examName + "')";
            isSuccess = stmt.executeUpdate(sql) > 0;

            if (isSuccess) {
                log.log(Level.INFO, "Exam added successfully");
            } else {
                log.log(Level.SEVERE, "Exam adding failed");
            }

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return isSuccess;
    }

    @Override
    public boolean deleteExam(int examId) {
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();

            String sql = "Delete from Exams where exam_id = '" + examId + "'";
            isSuccess = stmt.executeUpdate(sql) > 0;

            if (isSuccess) {
                log.log(Level.INFO, "Exam deleted successfully");
            } else {
                log.log(Level.SEVERE, "Exam deleting failed");
            }

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return isSuccess;
    }

    @Override
    public boolean updateExam(Exam exam) {
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();

            int examId = exam.getExamId();
            int classId = exam.getClassId();
            int academicStaffId = exam.getAcademicStaffId();
            String examName = exam.getExamName();

            String sql = "Update Exams set class_id = '" + classId + "', academic_staff_id = '" + academicStaffId
                    + "', exam_name = '" + examName + "' where exam_id = '" + examId + "'";
            isSuccess = stmt.executeUpdate(sql) > 0;

            if (isSuccess) {
                log.log(Level.INFO, "Exam updated successfully");
            } else {
                log.log(Level.SEVERE, "Exam updating failed");
            }

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return isSuccess;
    }

    @Override
    public List<Exam> getExams() {
        ArrayList<Exam> exams = new ArrayList<Exam>();
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();

            String sql = "Select * from Exams";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int examId = rs.getInt(1);
                int classId = rs.getInt(2);
                int academicStaffId = rs.getInt(3);
                String examName = rs.getString(4);
                String createdAt = rs.getString(5);
                String updatedAt = rs.getString(6);

                Exam exam = new Exam(examId, classId, academicStaffId, examName, createdAt, updatedAt);
                exams.add(exam);
            }

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return exams;
    }

    @Override
    public Exam getExamById(int id) {
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();

            String sql = "Select * from Exams where exam_id = '" + id + "'";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int examId = rs.getInt(1);
                int classId = rs.getInt(2);
                int academicStaffId = rs.getInt(3);
                String examName = rs.getString(4);
                String createdAt = rs.getString(5);
                String updatedAt = rs.getString(6);

                Exam exam = new Exam(examId, classId, academicStaffId, examName, createdAt, updatedAt);
                return exam;
            }

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

}
