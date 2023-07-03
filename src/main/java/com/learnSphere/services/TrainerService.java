package com.learnSphere.services;

import java.util.List;

import com.learnSphere.entity.Course;
import com.learnSphere.entity.Lesson;

public interface TrainerService {
  public String addcourese(Course c);
  public Course getCourse(int courseId);
  public String addlesson(Lesson lesson);
  public List<Course> courseList();
}
