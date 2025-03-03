
package com.socialservice.unfollowuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class UnfollowUserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UnfollowUserServiceApplication.class, args);
    }
}

@RestController
class UnfollowUserController {
    @DeleteMapping("/unfollow")
    public String unfollowUser(@RequestParam String userId, @RequestParam String followerId) {
        return "User " + followerId + " unfollowed user " + userId;
    }
}