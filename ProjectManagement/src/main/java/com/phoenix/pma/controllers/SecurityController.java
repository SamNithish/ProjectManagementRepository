package com.phoenix.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.phoenix.pma.dao.userRepository;
import com.phoenix.pma.entities.users;

@Controller
public class SecurityController {

	@Autowired
	BCryptPasswordEncoder bCryptEncoder;

	@Autowired
	userRepository useRepo;

	@GetMapping("/register")
	public String register(Model model) {
		users u = new users();
		model.addAttribute("hey", u);
		return "Security/register";
	}

	@PostMapping("/register/save")
	public String save(users u) {
		u.setPassword(bCryptEncoder.encode(u.getPassword()));
		u.setEnabled(true);
		useRepo.save(u);
		return "redirect:/home";
	}

}
