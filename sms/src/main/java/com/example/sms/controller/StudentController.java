package com.example.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;

import jakarta.websocket.server.PathParam;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public String listStudents(Model model)
	{
		model.addAttribute("students",studentService.getAllStudent());
		return "students";
	}
	@GetMapping("/students/new")
	public String createStudentForm(Model model)
	{
		Student student = new Student();
		model.addAttribute("student",student);
		return "create_student";
	}
	@PostMapping("/students")
	public String saveStudnet(@ModelAttribute("student")Student student)
	{
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	@GetMapping("student/edit/{id}")
	public String editStudent(@PathVariable long id,Model model)
	{
		model.addAttribute("student",studentService.getStudentById(id));
		return "editStudentDetails";
	}
	
	@PostMapping("/students/update/{id}")
	public String updateStudent(@PathVariable long id,
			@ModelAttribute("student") Student student,Model model)
	{
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(student.getId());
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	@GetMapping("/student/delete/{id}")
	public String  deleteStudent(@PathVariable long id)
	{
		studentService.deleteById(id);
		return "redirect:/students";
	}
}