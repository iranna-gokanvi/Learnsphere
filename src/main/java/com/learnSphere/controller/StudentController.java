package com.learnSphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnSphere.entity.Lesson;
import com.learnSphere.services.StudentService;
@Controller
public class StudentController {
	@Autowired
	StudentService sservice;
	
	@PostMapping("/viewlesson")
	public String myLesson(@RequestParam("lessonId") int lessonId,Model model) {
		Lesson lessons=sservice.getLesson(lessonId);
		model.addAttribute("lesson",lessons);
		System.out.println(lessons);
		return "mylesson";
	}


	
}
