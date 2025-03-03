
package com.socialservice.followerscount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class FollowersCountServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FollowersCountServiceApplication.class, args);
    }
}

@RestController
class FollowersCountController {
    @GetMapping("/followers/count")
    public int getFollowersCount(@RequestParam String userId) {
        return 123; // Simulando cantidad de seguidores
    }
}