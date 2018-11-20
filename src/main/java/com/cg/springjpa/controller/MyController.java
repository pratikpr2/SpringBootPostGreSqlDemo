package com.cg.springjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.springjpa.model.Customer;
import com.cg.springjpa.repo.CustomerRepo;

@RestController
public class MyController {

	@Autowired
	CustomerRepo repo;
	
	@RequestMapping("/save")
	public String process() {
		repo.save(new Customer("Jack","Smith"));
		return "Saved";
	}
	
	@RequestMapping("/findAll")
	public String findAll() {
		String result ="<html>";
		for(Customer cust: repo.findAll()) {
			result+= "<div>"+cust.toString()+"<div>";
		}
		return result + "</html>";
	}
	
	@RequestMapping("/findById")
	public String findById(@RequestParam("id") long id) {
		String result = "";
		result = repo.findById(id).toString();
		return result;
	}
	
	@RequestMapping("/findByLastName")
	public String findById(@RequestParam("lastName") String lastName) {
		String result = "<html>";
		for(Customer cust: repo.findByLastName(lastName)) {
			result+= "<div>"+cust.toString()+"<div>";
		}
		return result + "</html>";
	}
}
