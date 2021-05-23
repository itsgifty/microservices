package com.itsgifty.user.controller;

import com.itsgifty.user.VO.ResponseTemplateVO;
import com.itsgifty.user.entity.User;
import com.itsgifty.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/")
    public User saveUser (@RequestBody User user){
      log.info("inside save user of user controller");
        return userService.saveUser(user);
    }
    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartmentId(@PathVariable("id") Long userId){
        log.info("inside getUserWithDepartmentId of user controller");
        return userService.getUserWithDepartmentId(userId);
    }
}
