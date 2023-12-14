package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/get-book-list")
public class BookRestController {

	@Autowired
	StudentService service;

	@GetMapping(value = "/book")
	@Operation(description = "get book")
	public ResponseEntity<List<Student>> getBookList(@RequestParam int id) {
		List<Student> studentList = service.getStudentById(id);
		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
	}

	@GetMapping
	public String getData() {
		return "name";

	}

}
