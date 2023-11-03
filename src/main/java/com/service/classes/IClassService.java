package com.service.classes;

import java.util.List;

import com.model.ClassX;

public interface IClassService {
    public List<ClassX> getClasses();
    public ClassX getClassById(int id);
    public boolean addClass(ClassX classX);
    public boolean updateClass(ClassX classX);
    public boolean deleteClass(int id);
}
