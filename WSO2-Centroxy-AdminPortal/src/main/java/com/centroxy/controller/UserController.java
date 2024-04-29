package com.centroxy.controller;


import com.centroxy.entity.Group;
import com.centroxy.entity.User;
import com.centroxy.service.GroupService;
import com.centroxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;
@Autowired
    private BCryptPasswordEncoder passwordEncoder;



//    @PostMapping("/addUserByAdmin")
//    public User addUser(@RequestBody User user) {
//        Group group = groupService.getGroupById(user.getGroup().getId());
//        user.setGroup(group);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userService.saveUser(user);
//    }
//
//        @PostMapping("/addGroupByAdmin")
//        public Group addGroup(@RequestBody Group group) {
//            return groupService.saveGroup(group);
//        }

   // }


        @PostMapping("/addUserByAdmin")
        public ResponseEntity<User> addUser(@RequestBody User user) {
            try {
                // Encode the user's password before saving
                user.setPassword(passwordEncoder.encode(user.getPassword()));

                // Save the user
                User savedUser = userService.saveUser(user);

                // Return the saved user with HTTP status 201 Created
                return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
            } catch (Exception e) {
                // If an error occurs, return HTTP status 500 Internal Server Error
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @PostMapping("/addGroupByAdmin")
        public ResponseEntity<Group> addGroup(@RequestBody Group group) {
            try {
                // Save the group
                Group savedGroup = groupService.saveGroup(group);

                // Return the saved group with HTTP status 201 Created
                return new ResponseEntity<>(savedGroup, HttpStatus.CREATED);
            } catch (Exception e) {
                // If an error occurs, return HTTP status 500 Internal Server Error
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

