package com.sam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sam.entity.Student;

public interface StudentDAO extends JpaRepository<Student, Integer> {

}
