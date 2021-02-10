package com.buddhi.librarymanagementsystem.service;

import com.buddhi.librarymanagementsystem.model.Student;

public interface StudentService {


    Student save(Student student);
    public Student fetchStudentById(int id);

}
