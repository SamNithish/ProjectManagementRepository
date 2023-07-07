package com.phoenix.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.phoenix.pma.dao.ProjectRepository;
import com.phoenix.pma.dto.projectTimes;

@Controller
@RequestMapping("/timeline")
public class timelineController {
	
	@Autowired
	ProjectRepository proRepo;

	@GetMapping
	public String projectTimeline(Model model) throws JsonProcessingException {
		List<projectTimes> timedate = (List<projectTimes>) proRepo.timeline();
		ObjectMapper objMap = new ObjectMapper();
		String jsonTimelineString = objMap.writeValueAsString(timedate);
		model.addAttribute("heyChart", jsonTimelineString);
		model.addAttribute("allProjects", timedate);
		System.out.println(jsonTimelineString);
		return "timeline";
	}
	
}
