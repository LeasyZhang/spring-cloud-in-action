package com.example.cloud.controller;

import com.example.cloud.model.User;
import com.example.cloud.repository.UserRepository;
import com.google.gson.Gson;
import io.micrometer.core.instrument.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        User findOne = this.userRepository.findById(id).orElse(null);
        return findOne;
    }

    @GetMapping("/get")
    public String generateRspJson(@RequestParam(value = "username") String username,
                                  @RequestParam(value = "address") String address){
        SimpleRsp rsp = new SimpleRsp();
        rsp.setCode(HttpStatus.OK.toString());
        rsp.setMessage(username + address);
        return new Gson().toJson(rsp);
    }

    @PostMapping("/post")
    public String acceptUser(@RequestBody User user){
        return new Gson().toJson(user);
    }

    class SimpleRsp {
        String code;
        String message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
