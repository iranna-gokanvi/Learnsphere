package com.learnSphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnSphere.entity.Course;
import com.learnSphere.entity.Lesson;
import com.learnSphere.services.TrainerService;


@Controller
public class TrainerController{
	@Autowired
	TrainerService tservice;
	
	
	@PostMapping("/createCourse")
	public String createCourse(@RequestParam("courseId") int courseId,@RequestParam("courseName") String courseName,@RequestParam("coursePrice") int coursePrice ) {
		Course c=new Course();
		c.setCourseId(courseId);
		c.setCourseName(courseName);
		c.setCoursePrice(coursePrice);
		tservice.addcourese(c);
		return "redirect:/";
		
	}
	
	@PostMapping("/addLesson")
	public String lesson(@RequestParam("courseId") int courseId,@RequestParam("lessonId") int lessonId,@RequestParam("lessonName") String lessonName,@RequestParam("topics") String topics,@RequestParam("link") String link) {
		Course course=tservice.getCourse(courseId);
		Lesson lesson=new Lesson(lessonId, lessonName, topics, link, course);
		tservice.addlesson(lesson);
		course.getLesson().add(lesson);
		
		
		return "redirect:/";
	}
	
	@GetMapping("/course")
	public String showCourse(Model model) {
		List<Course> courses=tservice.courseList();
		System.out.println(courses);
	     model.addAttribute("courses", courses);
		return "viewcourse";
	}
	
	@GetMapping("/buyCourse")
	public String myCourse(Model model) {
		List<Course> courses=tservice.courseList();
		System.out.println(courses);
	     model.addAttribute("courses", courses);
		return "purchase";
	}
	

}
