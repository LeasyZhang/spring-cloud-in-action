package com.example.cloud.controller;

import com.example.cloud.feign.UserFeignClient;
import com.example.cloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        return userFeignClient.findById(id);
    }

    @GetMapping("/user/get")
    public String getJson(@RequestParam(value = "username") String username,
                          @RequestParam(value = "address") String address){
        return userFeignClient.get(username, address);
    }

    @PostMapping("/user/post")
    public String postUser(@RequestBody User user){
        return userFeignClient.post(user);
    }
}
