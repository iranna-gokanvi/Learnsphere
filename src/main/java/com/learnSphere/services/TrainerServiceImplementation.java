package com.learnSphere.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entity.Course;
import com.learnSphere.entity.Lesson;
import com.learnSphere.repository.CourseRepository;
import com.learnSphere.repository.LessonRepository;
@Service
public class TrainerServiceImplementation implements TrainerService{
	@Autowired
    CourseRepository courserepo;
	@Autowired
	LessonRepository lessonrepo;
   

	@Override
	public String addcourese(Course c) {
		courserepo.save(c);
		return "Course added";
	}


	@Override
	public Course getCourse(int courseId) {
		
		return courserepo.findById(courseId).get();
	}


	@Override
	public String addlesson(Lesson lesson) {
		lessonrepo.save(lesson);
		return "lesson added successfully";
	}


	@Override
	public List<Course> courseList() {
		
		return courserepo.findAll();
	}


	
   
}
