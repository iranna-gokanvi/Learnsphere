package com.learnSphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnSphere.entity.comments;

public interface CommentRepository extends JpaRepository<comments,Integer> {

}
