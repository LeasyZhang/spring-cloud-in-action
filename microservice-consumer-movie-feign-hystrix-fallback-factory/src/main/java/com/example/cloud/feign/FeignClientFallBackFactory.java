package com.example.cloud.feign;

import com.example.cloud.model.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallBackFactory implements FallbackFactory<UserFeignClient> {

    @Override
    public UserFeignClient create(Throwable cause) {
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                User defaultUser = new User();
                defaultUser.setName("Default");
                defaultUser.setId(-1L);
                return defaultUser;
            }
        };
    }
}
