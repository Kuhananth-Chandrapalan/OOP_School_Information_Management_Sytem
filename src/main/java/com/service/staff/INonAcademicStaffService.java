package com.service.staff;

import java.util.List;

import com.model.NonAcademicStaff;

public interface INonAcademicStaffService {

    public boolean addNonAcademicStaff(NonAcademicStaff nonAcademicStaff);

    public NonAcademicStaff getNonAcademicStaffById(int id);

    public List<NonAcademicStaff> getAllNonAcademicStaffDetails();

    public boolean updateNonAcademicStaff(NonAcademicStaff nonAcademicStaff);

    public boolean deleteNonAcademicStaff(int id);
}
