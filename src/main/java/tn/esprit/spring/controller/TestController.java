package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Service.UserDetailsServiceImpl;
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/test")
@RestController

public class TestController {
	@Autowired
	UserDetailsServiceImpl users;
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/EMPL")
		public String userAccess() {
		users.accesuser();
		return "EMPL Content.";
	}
	@GetMapping("/COMPA")
	@PreAuthorize("hasRole('COMPA')")
	public String moderatorAccess() {
		System.out.println("asasasas");
		return "";
	}
	@GetMapping("/ADMIN")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "ADMIN Board.";
	}
}
