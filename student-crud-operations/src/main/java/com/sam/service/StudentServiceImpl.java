package com.sam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sam.dao.StudentDAO;
import com.sam.dto.StudentDTO;
import com.sam.entity.Student;
import com.sam.exception.StudentException;

import jakarta.transaction.Transactional;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDAO;

	@Override
	public Integer saveStudent(StudentDTO studentDTO) throws StudentException 
	{
		Student student = new Student();
		student.setName(studentDTO.getName());
		student.setEmail(studentDTO.getEmail());
		student.setMobile(studentDTO.getMobile());
		
		return studentDAO.save(student).getId();
	}

	@Override
	public StudentDTO getStudentById(Integer id) throws StudentException 
	{
		Optional<Student> optional = studentDAO.findById(id);
		Student student = optional.orElseThrow(()-> new StudentException("Student Id Not Found"));
		
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(id);
		studentDTO.setName(student.getName());
		studentDTO.setEmail(student.getEmail());
		studentDTO.setMobile(student.getMobile());
		
		return studentDTO;
	}

	@Override
	public List<StudentDTO> getAllStudent() throws StudentException {
		List<Student> students = studentDAO.findAll();
		
		List<StudentDTO> studentDTOs = new ArrayList<>();
		
		if(students.isEmpty())
		{
			throw new StudentException("Student List Is Empty");
		}
		
		students.forEach(student->{
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setId(student.getId());
			studentDTO.setName(student.getName());
			studentDTO.setEmail(student.getEmail());
			studentDTO.setMobile(student.getMobile());
			studentDTOs.add(studentDTO);
		});
		
		
		return studentDTOs;
	}

	@Override
	public StudentDTO updateStudent(Integer id, StudentDTO studentDTO) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteStudent(Integer id) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

}
