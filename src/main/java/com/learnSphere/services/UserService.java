package com.learnSphere.services;

import com.learnSphere.entity.Users;

public interface UserService {
   public String addUser(Users u);
   public boolean loginusers(String email,String password);
   public boolean checkEmail(String email);
  public boolean validRole(String email);
  public Users getpass(String email);
	   
   
}
