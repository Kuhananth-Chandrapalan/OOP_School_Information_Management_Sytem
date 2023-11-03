package com.service.exam;

import java.util.List;

import com.model.Exam;

public interface IExamService {
    public boolean addExam(Exam exam);

    public boolean deleteExam(int examId);

    public boolean updateExam(Exam exam);

    public List<Exam> getExams();

    public Exam getExamById(int id);
}
