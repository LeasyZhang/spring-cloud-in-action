package com.example.cloud.controller;

import com.example.cloud.feign.UserFeignClient;
import com.example.cloud.model.User;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Import(FeignClientsConfiguration.class)
@RestController
public class MovieController {

    private UserFeignClient userFeignClient;

    private UserFeignClient adminFeignClient;

    @Autowired
    public MovieController(Decoder decoder, Encoder encoder, Client client, Contract contract){
        this.userFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(new SpringMvcContract())
                .requestInterceptor(new BasicAuthRequestInterceptor("user","password1"))
                .target(UserFeignClient.class, "http://microservice-provide-user/");

        this.adminFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(new SpringMvcContract())
                .requestInterceptor(new BasicAuthRequestInterceptor("admin","admin"))
                .target(UserFeignClient.class, "http://microservice-provide-user/");
    }

    @RequestMapping(path = "/user-user/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable Long id){
        return userFeignClient.findById(id);
    }

    @RequestMapping(path = "/user-admin/{id}", method = RequestMethod.GET)
    public User findByIdAdmin(@PathVariable Long id){
        return adminFeignClient.findById(id);
    }
}
