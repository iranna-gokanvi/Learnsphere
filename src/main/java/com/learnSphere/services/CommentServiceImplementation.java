package com.learnSphere.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entity.comments;
import com.learnSphere.repository.CommentRepository;

@Service
public class CommentServiceImplementation implements CommentService {
     @Autowired
	 CommentRepository commentrepo;
	@Override
	public String Commentadd(comments comment) {
	commentrepo.save(comment);
		return "comment added";
	}
	@Override
	public List<comments> displayComment() {
		List<comments> list=commentrepo.findAll();
		return list;
	}

}
