package com.example.demo1.controller;

import com.example.demo1.model.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class Controller {

	List<Employee> list = new ArrayList<Employee>();

	public Controller() {
		list.add(new Employee(1, "Atul", "IT"));
		list.add(new Employee(2, "Aditya", "IT"));
		list.add(new Employee(3, "Harsh", "IT"));

	}

	@GetMapping("/")
	public List<Employee> hello() {
		return list;
	}

	@PostMapping("/")
	public List<Employee> postMethod(@RequestBody Employee e) {
		list.add(e);
		return list;
	}

	@GetMapping("/{id}")
	public Employee getById(@PathVariable int id) {
		return list.get(id - 1);
	}

	@PutMapping("/")
	public List<Employee> putMethod(@RequestBody Employee e) {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == e.getId()) {
				list.set(i, e);
				return list;
			}
		}

		list.add(e);
		return list;
	}

	@DeleteMapping("/{id}")
	public List<Employee> deleteMethod(@PathVariable int id) {
		list.set(id-1, null);
		return list;
		
	}

}
