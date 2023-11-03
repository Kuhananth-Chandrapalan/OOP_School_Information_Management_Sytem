package com.service.student;

import com.model.Student;

import java.util.List;

public interface IStudentService {
	/**
     * Add Student
     * @param student
     * 
     * @return boolean
     */
    public boolean addStudent(Student student);

    /**
     * Get Student details by id
     * @param id
     * 
     * @return Student Object
     */

    public Student getStudentById(int id);

    /**
     * Get all list of students
     * 
     * @return List<Student>
     */
    public List<Student> getAllStudentDetails();

    /**
     * Update Student
     * @param student
     * 
     * @return boolean
     */

    public boolean updateStudent(Student student);

    /**
     * Delete Student
     * @param id
     * 
     * @return boolean
     */

    public boolean deleteStudent(int id);

}



