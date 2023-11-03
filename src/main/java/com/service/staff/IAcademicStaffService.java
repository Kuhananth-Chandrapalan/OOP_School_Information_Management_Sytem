package com.service.staff;

import java.util.List;

import com.model.AcademicStaff;

public interface IAcademicStaffService {

    public boolean addAcademicStaff(AcademicStaff AcademicStaff);

    public AcademicStaff getAcademicStaffById(int id);

    public List<AcademicStaff> getAllAcademicStaffDetails();

    public boolean updateAcademicStaff(AcademicStaff AcademicStaff);

    public boolean deleteAcademicStaff(int id);

}
