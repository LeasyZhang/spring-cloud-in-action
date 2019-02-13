package com.example.cloud.feign;

import com.example.cloud.model.User;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallBack implements UserFeignClient{

    @Override
    public User findById(Long id) {
        User defaultUser = new User();
        defaultUser.setName("Default");
        defaultUser.setId(-1L);
        return defaultUser;
    }

}
