package com.example.demo.utility;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentEntity;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentImpl implements StudentService {

	@Autowired
	StudentRepository repo;

	@Override
	public List<Student> getStudentById(int id) {
		ModelMapper mapper = new ModelMapper();
		List<Student> student = Collections.emptyList();
		List<StudentEntity> studentEnt = repo.findById(100).stream().map(v -> v).collect(Collectors.toList());
		studentEnt.forEach(studentList -> {
			Student std = mapper.map(studentEnt, Student.class);
			student.add(std);
		});
		// return student;
		return dummyData();
	}

	private static List<Student> dummyData() {
		List<Student> stdList = Arrays.asList(new Student(100, "Netaji", "30", "MCA", "A+", "77"),
				new Student(100, "Netaji", "30", "MCA", "A+", "77"),
				new Student(100, "Netaji", "30", "MCA", "A+", "77"),
				new Student(100, "Netaji", "30", "MCA", "A+", "77"));
		return stdList;

	}

}
