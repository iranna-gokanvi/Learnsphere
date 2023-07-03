package com.learnSphere.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entity.Lesson;
import com.learnSphere.repository.LessonRepository;

@Service
public class StudentServiceImplementation implements StudentService{
	@Autowired
	LessonRepository lessonrepo;
	@Override
	public Lesson getLesson(int lessonId) {
		
		return lessonrepo.findById(lessonId).get();
	}
}
