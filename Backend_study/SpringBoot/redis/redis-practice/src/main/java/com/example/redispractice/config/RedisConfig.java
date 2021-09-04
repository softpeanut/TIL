package com.example.redispractice.config;

import com.example.redispractice.domain.User;
import com.example.redispractice.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RedisConfig implements ApplicationRunner {

    private final UserRepository userRepository;
//    private final StringRedisTemplate redisTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
/*        ValueOperations<String, String> data = this.redisTemplate.opsForValue();

        data.set("001", "loveme");
        data.set("002", "1234");
        data.set("003", "aaa");keys

        User account = new User();
        account.setEmail("han@gmail.com");
        account.setUsername("hansj");

        this.userRepository.save(account);*/

        User user = new User();
        user.setUsername("abcedf");
        user.setEmail("abcdef@naver.com");

        userRepository.save(user);

        Optional<User> byId = userRepository.findById(user.getId());
        System.out.println(byId.get().getEmail());
        System.out.println(byId.get().getUsername());

    }
}
