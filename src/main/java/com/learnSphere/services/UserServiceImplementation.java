package com.learnSphere.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entity.Users;
import com.learnSphere.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	UserRepository ur;

	public UserServiceImplementation(UserRepository ur) {
		super();
		this.ur = ur;
	}

	@Override
	public String addUser(Users u) {
		ur.save(u);
		return "user registerd";
	}

	@Override
	public boolean loginusers(String email, String password) {
		Users uu = ur.getByEmail(email);
		String dbpass = uu.getPassword();
		if (dbpass.equals(password)) {
			return true;

		} else {
			return false;
		}

	}
	

	@Override
	public boolean checkEmail(String email) {

		return ur.existsByEmail(email);
	}

	@Override
	public boolean validRole(String email) {
		Users uu = ur.getByEmail(email);
		String roletype=uu.getRole();
		if(roletype.equals("student"))
		{
		return true;}
		else {
			return false;
		}
	}

	@Override
	public Users getpass(String email) {
		Users u=ur.getByEmail(email);
		return u;
	}

}
