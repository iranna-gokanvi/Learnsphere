package com.learnSphere.services;

import java.util.List;

import com.learnSphere.entity.comments;

public interface CommentService {
  public String Commentadd(comments comment);
  public List<comments> displayComment(); 
}
