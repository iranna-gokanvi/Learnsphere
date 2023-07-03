package com.learnSphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnSphere.entity.comments;
import com.learnSphere.services.CommentService;

@Controller
public class CommentController {
	@Autowired
	CommentService cservice;
	
	@PostMapping("/addcomment")
	public String addComment(@RequestParam("comment") String comment,Model model) {
		comments cm=new comments();
		cm.setComment(comment);
		cservice.Commentadd(cm);
		List<comments> commentlist=cservice.displayComment();
		model.addAttribute("comm", commentlist);
		System.out.println(commentlist);
		return "redirect/myless";
	}

}
