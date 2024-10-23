package com.Jwt.Controller;
import com.Jwt.Model.User;
import com.Jwt.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
@RestController
@RequestMapping("/home")
public class TestController
{
    @GetMapping("/user")
    public List<User> getUserInfo()
    {
        UserService userService=new UserService();
        List<User>userList= userService.getUser();
        return  userList;
    }
    @GetMapping("/Currentuser")
    public String getCurrent_User(Principal principal)
    {
        return principal.getName();
    }
}
