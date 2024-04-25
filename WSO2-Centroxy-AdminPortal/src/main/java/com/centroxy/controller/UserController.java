package com.centroxy.controller;


import com.centroxy.entity.Group;
import com.centroxy.entity.User;
import com.centroxy.service.GroupService;
import com.centroxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        Group group = groupService.getGroupById(user.getGroup().getId());

        user.setGroup(group);
        return userService.saveUser(user);
    }

    @PostMapping("/addGroup")
    public Group addGroup(@RequestBody Group group) {
        return groupService.saveGroup(group);
    }

}

