package com.example.sms.serviceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sms.entity.Student;
import com.example.sms.repository.StudentRepository;
import com.example.sms.service.StudentService;

@Service
public class ServiceImplementation implements StudentService{
	
	@Autowired
	private StudentRepository studentRepo;
	
	public List<Student> getAllStudent()
	{
		List<Student> student = studentRepo.findAll();
		System.out.println(student.toString());
		return studentRepo.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepo.findById(id).get();
	}

	@Override
	public void deleteById(long id) {
		studentRepo.deleteById(id);		
	}

}
