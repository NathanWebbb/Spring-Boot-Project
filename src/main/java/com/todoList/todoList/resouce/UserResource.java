package com.todoList.todoList.resouce;

import com.todoList.todoList.entity.Task;
import com.todoList.todoList.entity.User;
import com.todoList.todoList.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/getUser")
    public User getUser(@RequestBody Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestBody Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/getUserAllTasks")
    public List<Task> getUserAllTasks(@RequestParam(name = "userId") Long userId) {
        return userService.getUserAllTasks(userId);
    }

    @DeleteMapping("/deleteTask")
    public void deleteTask(@RequestParam(name = "taskId") Long taskId) {
        userService.deleteTask(taskId);
    }

    @GetMapping("/getTaskById")
    public Task getTaskById(@RequestParam(name = "taskId") Long taskId) {
        return userService.getTaskById(taskId);
    }

}