package com.dating_app.controller;
import com.dating_app.model.User;
import com.dating_app.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private RecommendationService recommendationService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return recommendationService.registerUser(user);
    }

    @GetMapping("/recommendations/{userId}")
    public List<User> getRecommendations(@PathVariable Long userId) {
        User user = recommendationService.getUserById(userId);
        return recommendationService.getRecommendations(user);
    }
}
