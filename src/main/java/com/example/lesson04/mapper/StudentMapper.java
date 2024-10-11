package com.example.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson04.domain.Student;

@Mapper
public interface StudentMapper {

	
	// intput: Student
	// output: int or void
	public void insertStudent(Student student);
	
	// input : id 
	// output : Student 
	public Student selectStudentById(int id);
}
