package com.example.cloud.feign;

import com.example.cloud.config.FeignConfiguration;
import com.example.cloud.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "microservice-provide-user", configuration = FeignConfiguration.class)
public interface UserFeignClient {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    String get(@RequestParam(value = "username") String username,
               @RequestParam(value = "address") String address);

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    String post(@RequestBody User user);
}
