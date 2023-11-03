package com.model;

public class ClassX {
    private int classId;
    private int subjectId;
    private int academicStaffId;
    private String className;
    private String allocatedClassroom;

    public ClassX(int classId, int subjectId, int academicStaffId, String className, String allocatedClassroom) {
        this.classId = classId;
        this.subjectId = subjectId;
        this.academicStaffId = academicStaffId;
        this.className = className;
        this.allocatedClassroom = allocatedClassroom;
    }

    public ClassX(int subjectId, int academicStaffId, String className, String allocatedClassroom) {
        this.subjectId = subjectId;
        this.academicStaffId = academicStaffId;
        this.className = className;
        this.allocatedClassroom = allocatedClassroom;
    }

    //Getters
    public int getClassId() {
        return classId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public int getAcademicStaffId() {
        return academicStaffId;
    }

    public String getClassName() {
        return className;
    }

    public String getAllocatedClassroom() {
        return allocatedClassroom;
    }
}
