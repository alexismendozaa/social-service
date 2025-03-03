
package com.socialservice.followerslist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FollowersListServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FollowersListServiceApplication.class, args);
    }
}

@RestController
class FollowersListController {
    @GetMapping("/followers")
    public List<String> getFollowers(@RequestParam String userId) {
        return Arrays.asList("Follower1", "Follower2", "Follower3");
    }
}