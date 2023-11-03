package com.service.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.model.ClassX;
import com.util.DBConnectUtil;

public class ClassServiceImpl implements IClassService {
    /** Initialize logger */
    public static final Logger log = Logger.getLogger(ClassServiceImpl.class.getName());

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private boolean isSuccess;

    private static ClassServiceImpl instance;

    // private constructor
    private ClassServiceImpl() {
    }

    // get instance method for getting the instance of the class
    public static ClassServiceImpl getInstance() {
        if (instance == null)
            instance = new ClassServiceImpl();
        return instance;
    }

    @Override
    public List<ClassX> getClasses() {
        ArrayList<ClassX> classArray = new ArrayList<>();
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();
            String sql = "select * from Classes";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int classId = rs.getInt(1);
                int subjectId = rs.getInt(2);
                int academicStaffId = rs.getInt(3);
                String className = rs.getString(4);
                String allocatedClassroom = rs.getString(5);

                ClassX classX = new ClassX(classId, subjectId, academicStaffId, className, allocatedClassroom);
                classArray.add(classX);
            }

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return classArray;
    }

    @Override
    public ClassX getClassById(int id) {
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();
            String sql = "select * from Classes where class_Id='" + id + "'";
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                int classId = rs.getInt(1);
                int subjectId = rs.getInt(2);
                int academicStaffId = rs.getInt(3);
                String className = rs.getString(4);
                String allocatedClassroom = rs.getString(5);

                ClassX classX = new ClassX(classId, subjectId, academicStaffId, className, allocatedClassroom);
                return classX;
            }

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    @Override
    public boolean addClass(ClassX classX) {
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();

            int subjectId = classX.getSubjectId();
            int academicStaffId = classX.getAcademicStaffId();
            String className = classX.getClassName();
            String allocatedClassroom = classX.getAllocatedClassroom();

            String sql = "Insert into Classes (subject_id, academic_staff_id, class_name, allocated_classroom) values ('"
                    + subjectId + "','" + academicStaffId + "','" + className + "','" + allocatedClassroom + "')";
            isSuccess = stmt.executeUpdate(sql) > 0;

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return isSuccess;
    }

    @Override
    public boolean updateClass(ClassX classX) {
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();

            int classId = classX.getClassId();
            int subjectId = classX.getSubjectId();
            int academicStaffId = classX.getAcademicStaffId();
            String className = classX.getClassName();
            String allocatedClassroom = classX.getAllocatedClassroom();

            String sql = "update Classes set subject_id='" + subjectId + "', academic_staff_id='" + academicStaffId
                    + "', class_name='" + className + "', allocated_classroom='" + allocatedClassroom
                    + "' where class_id='"
                    + classId + "'";

            int rs = stmt.executeUpdate(sql);

            if (rs > 0) {
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
    public boolean deleteClass(int id) {
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();

            String sql = "delete from Classes where class_id='" + id + "'";

            int rs = stmt.executeUpdate(sql);

            if (rs > 0) {
                isSuccess = true;
            } else {
                isSuccess = false;
            }

        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return isSuccess;
    }

    // get class count
    public int getClassCount() {
        int count = 0;
        try {
            con = DBConnectUtil.getConnection();
            stmt = con.createStatement();
            String sql = "select count(*) from Classes";
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
