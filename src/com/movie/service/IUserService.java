package com.movie.service;

import java.util.List;

import com.movie.pojo.User;

public interface IUserService {
public User getUser(String id);  
    
    public List<User> getAllUser();  
      
    public void addUser(User user);  
      
    public boolean delUser(String id);  
      
    public boolean updateUser(User user);  
    
    public 	User login(String userName,String userPassword);
    
    public List<User> findByName(String userName);
}
