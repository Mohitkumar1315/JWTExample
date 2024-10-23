package com.Jwt.Services;

import com.Jwt.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService
{
    ArrayList<User> userList=new ArrayList<User>();
    public UserService()
    {
        userList.add(new User(UUID.randomUUID().toString(),"Varun","varun@gmail.com"));
        userList.add(new User(UUID.randomUUID().toString(),"mohit","mvkrampur1315@gmail.com"));
        userList.add(new User(UUID.randomUUID().toString(),"shubham","mvkrampur1315@gmail.com"));
    }
    public List<User> getUser()
    {
        return userList;
    }
}
