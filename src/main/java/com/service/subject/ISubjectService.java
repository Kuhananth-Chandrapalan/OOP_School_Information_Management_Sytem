package com.service.subject;

import java.util.List;

import com.model.Subject;

public interface ISubjectService {

    public boolean addSubject(Subject subject);

    public Subject getSubjectById(int id);

    public List<Subject> getAllSubjects();

    public boolean updateSubject(Subject subject);

    public boolean deleteSubject(int id);
}
