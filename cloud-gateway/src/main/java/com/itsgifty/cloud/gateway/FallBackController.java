package com.itsgifty.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {
    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod(){
        return ("User service is taking longer than usual "+"please try again after some time");
    }
    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallBackMethod(){
        return ("Department service is taking longer than usual "+"please try again after some time");
    }
}
