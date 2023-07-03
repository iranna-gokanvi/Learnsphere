package com.learnSphere.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.learnSphere.entity.Users;
import java.util.List;


public interface UserRepository extends JpaRepository<Users,Integer>{
	boolean existsByEmail(String email);
	Users getByEmail(String email);



}
