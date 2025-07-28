package com.sam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.dto.StudentDTO;
import com.sam.exception.StudentException;
import com.sam.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/students")
	public ResponseEntity<String> saveStudent(@RequestBody StudentDTO studentDTO) throws StudentException 
	{
		Integer studId = studentService.saveStudent(studentDTO);
		String msg = "Student added Successfully having Id :-"+studId;
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<StudentDTO> getStudentById(@PathVariable Integer id) throws StudentException
	{
		StudentDTO studentDTO = studentService.getStudentById(id);
		return new ResponseEntity<>(studentDTO, HttpStatus.OK);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<StudentDTO>> getAllStudent() throws StudentException
	{
		List<StudentDTO> studentDTO = studentService.getAllStudent();
		return new ResponseEntity<>(studentDTO, HttpStatus.OK);
	}

}
