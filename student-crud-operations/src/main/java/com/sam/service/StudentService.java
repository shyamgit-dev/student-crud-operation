package com.sam.service;

import java.util.List;

import com.sam.dto.StudentDTO;
import com.sam.exception.StudentException;


public interface StudentService {
	
	public Integer saveStudent(StudentDTO studentDTO)throws StudentException;
	public StudentDTO getStudentById(Integer id) throws StudentException;
	public List<StudentDTO> getAllStudent() throws StudentException;
	public StudentDTO updateStudent(Integer id,StudentDTO studentDTO) throws StudentException;
	public Integer deleteStudent(Integer id)throws StudentException;

}
