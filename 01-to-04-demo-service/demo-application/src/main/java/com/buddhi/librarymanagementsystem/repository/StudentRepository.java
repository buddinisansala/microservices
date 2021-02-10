package com.buddhi.librarymanagementsystem.repository;

import com.buddhi.librarymanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
