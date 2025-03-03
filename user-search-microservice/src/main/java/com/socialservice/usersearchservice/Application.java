
package com.socialservice.usersearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class UserSearchServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserSearchServiceApplication.class, args);
    }
}

@RestController
class UserSearchController {
    @GetMapping("/search")
    public String searchUser(@RequestParam String username) {
        return "User found: " + username;
    }
}