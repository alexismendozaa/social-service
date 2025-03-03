
package com.socialservice.followuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class FollowUserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FollowUserServiceApplication.class, args);
    }
}

@RestController
class FollowUserController {
    @PostMapping("/follow")
    public String followUser(@RequestParam String userId, @RequestParam String followerId) {
        return "User " + followerId + " followed user " + userId;
    }
}